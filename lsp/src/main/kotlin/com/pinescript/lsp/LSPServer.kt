package com.pinescript.lsp

import com.pinescript.core.PineEngine
import com.pinescript.core.PineScriptParseException
import com.pinescript.lsp.LSPMethod.Companion.fromMethod
import com.pinescript.lsp.models.CompletionItem
import com.pinescript.lsp.models.CompletionItemKind
import com.pinescript.lsp.models.CompletionProvider
import com.pinescript.lsp.models.ErrorCode
import com.pinescript.lsp.models.HoverParams
import com.pinescript.lsp.models.HoverResponse
import com.pinescript.lsp.models.JsonRPCHeader
import com.pinescript.lsp.models.JsonRPCRequest
import com.pinescript.lsp.models.JsonRPCServerCapabilitiesImpl
import com.pinescript.lsp.models.LSPCompletionList
import com.pinescript.lsp.models.LSPDiagnostic
import com.pinescript.lsp.models.LSPEmptyParams
import com.pinescript.lsp.models.LSPInitializeParams
import com.pinescript.lsp.models.LSPInitializeServerResult
import com.pinescript.lsp.models.LSPNotification
import com.pinescript.lsp.models.LSPResponse
import com.pinescript.lsp.models.LSPServerInfo
import com.pinescript.lsp.models.MarkupContent
import com.pinescript.lsp.models.Position
import com.pinescript.lsp.models.PublishDiagnosticsParams
import com.pinescript.lsp.models.Range
import com.pinescript.lsp.models.ResponseError
import com.pinescript.lsp.models.TextDocumentCompletionParams
import com.pinescript.lsp.models.TextDocumentDidChangeParams
import com.pinescript.lsp.models.TextDocumentDidOpenParams
import com.pinescript.lsp.models.TextDocumentItem
import com.pinescript.lsp.models.TextDocumentSymbolParams
import com.pinescript.lsp.models.TextDocumentSyncKind
import com.pinescript.lsp.models.TextDocumentSyncKindAdapter
import com.pinescript.lsp.models.WorkspaceFoldersCapabilities
import com.pinescript.lsp.models.WorkspaceFoldersServerCapabilities
import com.pinescript.lsp.models.getObjectTypeEnclosingPosition
import com.pinescript.lsp.models.getWordAtPosition
import com.pinescript.lsp.models.jsonRpc
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.util.CharsetUtil
import java.net.InetSocketAddress

enum class LSPMethod(val method: String, val paramType: Class<*>) {
    Ignore("$", LSPEmptyParams::class.java),
    Initialize("initialize", LSPInitializeParams::class.java),
    Initialized("initialized", LSPEmptyParams::class.java),
    TextDocumentDidOpen("textDocument/didOpen", TextDocumentDidOpenParams::class.java),
    TextDocumentDidChange("textDocument/didChange", TextDocumentDidChangeParams::class.java),
    TextDocumentDocumentSymbol(
        "textDocument/documentSymbol",
        TextDocumentSymbolParams::class.java
    ),
    TextDocumentCompletion("textDocument/completion", TextDocumentCompletionParams::class.java),
    Hover("textDocument/hover", HoverParams::class.java),
    Shutdown("shutdown", LSPEmptyParams::class.java),
    PublishDiagnotics("textDocument/publishDiagnostics", LSPDiagnostic::class.java);

    companion object {
        fun fromMethod(method: String): LSPMethod {
            return values().firstOrNull { method == it.method } ?: Ignore
        }
    }
}

interface LSPDelegate {
    fun onInitialize(capabilities: LSPInitializeParams): LSPInitializeServerResult
    fun onInitialized()
    fun onShutdown()
    fun onHover(hover: HoverParams): HoverResponse?
    fun onTextDocumentDidOpen(doc: TextDocumentDidOpenParams): PublishDiagnosticsParams
    fun onTextDocumentDocumentSymbol(doc: TextDocumentSymbolParams): LSPDiagnostic
    fun onTextDocumentDidChange(doc: TextDocumentDidChangeParams):
            PublishDiagnosticsParams

    fun onTextDocumentCompletion(documentCompletionParams: TextDocumentCompletionParams):
            LSPCompletionList
}

fun jsonRPCHeader(data: String): JsonRPCHeader {
    val regex = "Content-Length: ([0-9]+)".toRegex()
    try {
        val size = regex.find(data)?.groupValues?.get(1)!!.toInt()
        return JsonRPCHeader(size)
    } catch (e: Exception) {
        throw RuntimeException("Unable to parse header: $data")
    }
}

class LSPRequestAdapter : JsonAdapter<JsonRPCRequest>() {

    private val moshi =
        Moshi.Builder().add(TextDocumentSyncKindAdapter()).add(KotlinJsonAdapterFactory()).build()

    @FromJson
    override fun fromJson(reader: JsonReader): JsonRPCRequest? {
        var id: Int? = null
        var method: String? = null
        var params: Any? = null
        var jsonrpc = "2.0"

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "jsonrpc" -> jsonrpc = reader.nextString()
                "id" -> id = reader.nextInt()
                "method" -> method = reader.nextString()
                "params" -> params = moshi.adapter(fromMethod(method!!).paramType).fromJson(reader)
            }
        }
        reader.endObject()
        return JsonRPCRequest(jsonrpc, id, method!!, params)
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: JsonRPCRequest?) {
    }
}

class LSPServer(private val delegate: LSPDelegate) {
    private var initialized = false
    var channelFuture: ChannelFuture? = null
    val group: EventLoopGroup = NioEventLoopGroup()

    private val moshi = Moshi.Builder()
        .add(TextDocumentSyncKindAdapter())
        .add(LSPRequestAdapter())
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun jsonRPCRequest(data: String): JsonRPCRequest {
        val adapter = moshi.adapter(JsonRPCRequest::class.java).lenient()
        return adapter.fromJson(data)!!
    }

    private fun handleRequest(request: JsonRPCRequest, output: ChannelHandlerContext) {
        val adapter = moshi.adapter(LSPResponse::class.java).serializeNulls().lenient()
        val notifyAdapter = moshi.adapter(LSPNotification::class.java).lenient()
        val responseData: String? = try {
            if (!initialized && request.method != "initialize") {
                jsonRpc(
                    adapter.toJson(
                        LSPResponse(
                            request.id,
                            null,
                            ResponseError(ErrorCode.ServerNotInitialized, "call initialize first")
                        )
                    )
                )
            } else {
                when (fromMethod(request.method)) {
                    LSPMethod.Initialize -> {
                        initialized = true
                        val result = delegate.onInitialize(request.params as LSPInitializeParams)
                        val response = LSPResponse(request.id, result, null)
                        jsonRpc(adapter.toJson(response))
                    }
                    LSPMethod.Initialized -> {
                        delegate.onInitialized()
                        null
                    }
                    LSPMethod.TextDocumentDidOpen -> {
                        val note =
                            delegate.onTextDocumentDidOpen(
                                request.params as TextDocumentDidOpenParams)
                        jsonRpc(
                            notifyAdapter.toJson(
                                LSPNotification(
                                    LSPMethod.PublishDiagnotics.method,
                                    note
                                )
                            )
                        )
                    }
                    LSPMethod.TextDocumentDidChange -> {
                        val note =
                            delegate.onTextDocumentDidChange(
                                request.params as TextDocumentDidChangeParams)
                        jsonRpc(
                            notifyAdapter.toJson(
                                LSPNotification(
                                    LSPMethod.PublishDiagnotics.method,
                                    note
                                )
                            )
                        )
                    }
                    LSPMethod.TextDocumentDocumentSymbol -> {
//                        val note = delegate.onTextDocumentDocumentSymbol(request.params as TextDocumentDocumentSymbolParams)
//                        jsonRpc(notifyAdapter.toJson(LSPNotification(LSPMethod.PublishDiagnotics.method, note)))
                        val response = LSPResponse(request.id, null, null)
                        jsonRpc(adapter.toJson(response))
                    }
                    LSPMethod.TextDocumentCompletion -> {
                        val response =
                            delegate.onTextDocumentCompletion(
                                request.params as TextDocumentCompletionParams)
                        jsonRpc(adapter.toJson(LSPResponse(request.id, response, null)))
                    }
                    LSPMethod.Hover -> {
                        val response = delegate.onHover(
                            request.params as HoverParams)
                        jsonRpc(adapter.toJson(LSPResponse(request.id, response, null)))
                    }
                    LSPMethod.Shutdown -> {
                        delegate.onShutdown(); null
                    }
                    else -> null
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            jsonRpc(
                adapter.toJson(
                    LSPResponse(
                        request.id,
                        null,
                        ResponseError(ErrorCode.MethodNotFound),
                        request.jsonrpc
                    )
                )
            )
        }
        println("response: $responseData\n")
        responseData?.run {
            output.writeAndFlush(Unpooled.copiedBuffer(responseData, CharsetUtil.UTF_8))
        }
    }

    fun startNettyServer(hostname: String = "localhost", port: Int = 2323) {
        val serverBootstrap = ServerBootstrap()
        serverBootstrap.group(group)
        serverBootstrap.channel(NioServerSocketChannel::class.java)
        serverBootstrap.localAddress(InetSocketAddress(hostname, port))
        serverBootstrap.childHandler(object : ChannelInitializer<SocketChannel?>() {
            @Throws(java.lang.Exception::class)
            override fun initChannel(socketChannel: SocketChannel?) {
                socketChannel!!.pipeline().addLast(RpcJsonHandler())
                println("Socket accepted: ${socketChannel.remoteAddress()}")
            }
        })
        channelFuture = serverBootstrap.bind()
    }

    fun stopServer() {
        channelFuture?.channel()?.close()
        channelFuture?.channel()?.closeFuture()?.sync()
        group.shutdownGracefully().sync()
    }
    // fun response(method: String, params: Any?) = JsonRPCRequest(id++, method, params)

    enum class RpcJsonState {
        Header, Empty, Request
    }

    inner class RpcJsonHandler : ChannelInboundHandlerAdapter() {

        private val builder = Unpooled.compositeBuffer()
        private var state = RpcJsonState.Header
        private var contentSize = 0

        @Throws(java.lang.Exception::class)
        override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
            val inBuffer: ByteBuf = msg as ByteBuf
            builder.addComponent(true, inBuffer)
        }

        @OptIn(ExperimentalStdlibApi::class)
        @Throws(java.lang.Exception::class)
        override fun channelReadComplete(ctx: ChannelHandlerContext) {
            println("Server received complete size: ${builder.readableBytes()}")
            loop@ while (builder.readableBytes() > 0) {
                when (state) {
                    RpcJsonState.Header -> {
                        val idx = builder.bytesBefore('\n'.toByte()) + 1
                        if (idx > 0) {
                            val bytes = ByteArray(idx)
                            builder.readBytes(bytes)
                            println("HEADER: ${String(bytes)}")
                            state = RpcJsonState.Empty
                            try {
                                contentSize = jsonRPCHeader(String(bytes)).contentLength
                            } catch (e: Exception) {
                                // e.printStackTrace()
                            }
                        } else {
                            break@loop
                        }
                    }
                    RpcJsonState.Empty -> {
                        val idx = builder.bytesBefore('\n'.toByte()) + 1
                        if (idx > 0) {
                            println("EMPTY: $idx")
                            builder.skipBytes(idx)
                            state = RpcJsonState.Request
                        } else {
                            break@loop
                        }
                    }
                    RpcJsonState.Request -> {
                        if (builder.readableBytes() >= contentSize) {
                            val data = ByteArray(contentSize)
                            builder.readBytes(data)
                            println("REQUEST size: ${data.size} data: ${String(data)}")
                            state = RpcJsonState.Header
                            handleRequest(jsonRPCRequest(String(data)), ctx)
                        } else {
                            break@loop
                        }
                    }
                }
                builder.discardReadComponents()
            }
        }

        @Throws(java.lang.Exception::class)
        override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
            cause.printStackTrace()
            ctx.close()
        }
    }
}

class ServerImpl(private val pineEngine: PineEngine) : LSPDelegate {

    var docItem: TextDocumentItem? = null

    var textChangeListener: ((String) -> Unit)? = null

    override fun onInitialize(capabilities: LSPInitializeParams): LSPInitializeServerResult {

        val workspaceFolders = capabilities.capabilities.workspace?.workspaceFolders == true
        return LSPInitializeServerResult(
            capabilities = JsonRPCServerCapabilitiesImpl(
                textDocumentSync = TextDocumentSyncKind.Full, // TextDocumentSync(),
                completionProvider = CompletionProvider(
                    triggerCharacters = listOf("."),
                    resolveProvider = true
                ),
                workspace = if (workspaceFolders) WorkspaceFoldersServerCapabilities(
                    WorkspaceFoldersCapabilities(true)
                ) else null
            ),
            serverInfo = LSPServerInfo("PineLang Server")
        )
    }

    override fun onInitialized() {}
    override fun onShutdown() {}

    override fun onTextDocumentDidOpen(doc: TextDocumentDidOpenParams): PublishDiagnosticsParams {
        println("$doc")
        docItem = doc.textDocument
        textChangeListener?.let { it(doc.textDocument.text) }
        return generateDiagnostic(doc.textDocument.text)
    }

    override fun onTextDocumentDocumentSymbol(doc: TextDocumentSymbolParams): LSPDiagnostic {
        return LSPDiagnostic(
            Range(
                Position(0, 0),
                Position(0, 0)
            ), 3, ""
        )
    }

    override fun onTextDocumentDidChange(
        doc: TextDocumentDidChangeParams
    ): PublishDiagnosticsParams {
        println("$doc")
        docItem = TextDocumentItem(
            uri = doc.textDocument.uri,
            languageId = "pine",
            text = doc.contentChanges[0].text,
            version = doc.textDocument.version
        )
        textChangeListener?.let { it(doc.contentChanges[0].text) }
        return generateDiagnostic(doc.contentChanges[0].text)
    }

    override fun onTextDocumentCompletion(
        documentCompletionParams: TextDocumentCompletionParams
    ): LSPCompletionList {
        println("onTextDocumentCompletion")
        val text = docItem!!.text
        val incomplete = text.getWordAtPosition(documentCompletionParams.position) ?: ""
        val objType = text.getObjectTypeEnclosingPosition(documentCompletionParams.position)

        val propertyCompletionList = objType?.run {
            val type = pineEngine.types[objType] ?: return@run null
            (type.propNames() + listOf("id"))
                .filter { it != "children" }
                .filter { it.contains(incomplete) }
                .map {
                    CompletionItem(
                        label = it,
                        insertText = "$it:",
                        detail = "Property",
                        kind = CompletionItemKind.Field.value
                    )
                } +
                    type.signalNames()
                        .filter { it.contains(incomplete) }
                        .map {
                            CompletionItem(
                                label = it,
                                insertText = "on $it:",
                                detail = "Signal",
                                kind = CompletionItemKind.Event.value
                            )
                        } +
                    type.callableNames()
                        .filter { it.contains(incomplete) }
                        .map {
                            CompletionItem(
                                label = it,
                                insertText = "$it()",
                                detail = "Function",
                                kind = CompletionItemKind.Function.value
                            )
                        }
        } ?: listOf()

        val objCompletionList = pineEngine.types.index.keys
            .filter { it.contains(incomplete) }
            .map {
                CompletionItem(
                    label = "$it {",
                    detail = "Type",
                    kind = CompletionItemKind.Class.value
                )
            }
        return LSPCompletionList(
            isIncomplete = false,
            items = propertyCompletionList + objCompletionList
        )
    }

    override fun onHover(hover: HoverParams): HoverResponse? {
        println("onTextDocumentCompletion")
        if (docItem == null)
            return null
        val text = docItem!!.text
        val incomplete = text.getWordAtPosition(hover.position) ?: return null

        println("hovering on $incomplete")
        val range = Range(
            start = hover.position, end = hover.position
        )
        if (incomplete[0].isUpperCase()) {
            // This mean its a type
            val type = pineEngine.types[incomplete]
            if (type != null) {
                return HoverResponse(contents = MarkupContent(type.docString), range = range)
            }
        } else {
            // Means its a prop
            val objType = text.getObjectTypeEnclosingPosition(hover.position) ?: return null
            println("found $objType")
            val type = pineEngine.types[objType] ?: return null
            println("found $type")
            val prop = type.props.firstOrNull { it.name == incomplete } ?: return null
            println("found $prop")
            return HoverResponse(
                contents = MarkupContent("Property ${prop.name} of type ${prop.type.typeName}"),
                range = range
            )
        }

        return HoverResponse(MarkupContent("Don't know"), range = range)
    }

    private fun PineScriptParseException.toRange(): Range {
        return Range(
            Position(this.startLine - 1, this.startCol),
            Position(this.endLine - 1, this.endCol + 1)
        )
    }

    private fun generateDiagnostic(script: String): PublishDiagnosticsParams {
        return try {
            val ast = pineEngine.compile(script)
            println("AST: $ast")
            PublishDiagnosticsParams(
                uri = docItem!!.uri,
                diagnostics = listOf()
            )
        } catch (e: PineScriptParseException) {
            println("error: ${e.message}")
            PublishDiagnosticsParams(
                uri = docItem!!.uri,
                diagnostics = listOf(
                    LSPDiagnostic(
                        e.toRange(),
                        3,
                        severity = 1,
                        message = e.message!!,
                        source = "Pine Compiler"
                    )
                )
            )
        }
    }
}
