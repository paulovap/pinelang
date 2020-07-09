/*
BSD License

Copyright (c) 2020, Paulo Pinheiro
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Paulo Pinheiro nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.pinelang.lsp.lsp

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
import kotlin.OptIn as OptIn1
import org.pinelang.core.PineEngine
import org.pinelang.core.PineScriptParseException
import org.pinelang.lsp.lsp.LSPMethod.Companion.fromMethod
import org.pinelang.lsp.lsp.models.CompletionItem
import org.pinelang.lsp.lsp.models.CompletionItemKind
import org.pinelang.lsp.lsp.models.CompletionProvider
import org.pinelang.lsp.lsp.models.ErrorCode
import org.pinelang.lsp.lsp.models.HoverParams
import org.pinelang.lsp.lsp.models.HoverResponse
import org.pinelang.lsp.lsp.models.JsonRPCHeader
import org.pinelang.lsp.lsp.models.JsonRPCRequest
import org.pinelang.lsp.lsp.models.JsonRPCServerCapabilitiesImpl
import org.pinelang.lsp.lsp.models.LSPCompletionList
import org.pinelang.lsp.lsp.models.LSPDiagnostic
import org.pinelang.lsp.lsp.models.LSPEmptyParams
import org.pinelang.lsp.lsp.models.LSPInitializeParams
import org.pinelang.lsp.lsp.models.LSPInitializeServerResult
import org.pinelang.lsp.lsp.models.LSPNotification
import org.pinelang.lsp.lsp.models.LSPResponse
import org.pinelang.lsp.lsp.models.LSPServerInfo
import org.pinelang.lsp.lsp.models.MarkupContent
import org.pinelang.lsp.lsp.models.Position
import org.pinelang.lsp.lsp.models.PublishDiagnosticsParams
import org.pinelang.lsp.lsp.models.Range
import org.pinelang.lsp.lsp.models.ResponseError
import org.pinelang.lsp.lsp.models.TextDocumentCompletionParams
import org.pinelang.lsp.lsp.models.TextDocumentDidChangeParams
import org.pinelang.lsp.lsp.models.TextDocumentDidOpenParams
import org.pinelang.lsp.lsp.models.TextDocumentItem
import org.pinelang.lsp.lsp.models.TextDocumentSymbolParams
import org.pinelang.lsp.lsp.models.TextDocumentSyncKind
import org.pinelang.lsp.lsp.models.TextDocumentSyncKindAdapter
import org.pinelang.lsp.lsp.models.WorkspaceFoldersCapabilities
import org.pinelang.lsp.lsp.models.WorkspaceFoldersServerCapabilities
import org.pinelang.lsp.lsp.models.getObjectTypeEnclosingPosition
import org.pinelang.lsp.lsp.models.getWordAtPosition
import org.pinelang.lsp.lsp.models.jsonRpc

enum class LSPMethod(val method: String, val paramType: Class<*>) {
  Ignore("$", LSPEmptyParams::class.java),
  Initialize("initialize", LSPInitializeParams::class.java),
  Initialized("initialized", LSPEmptyParams::class.java),
  TextDocumentDidOpen("textDocument/didOpen", TextDocumentDidOpenParams::class.java),
  TextDocumentDidChange("textDocument/didChange", TextDocumentDidChangeParams::class.java),
  TextDocumentDocumentSymbol("textDocument/documentSymbol", TextDocumentSymbolParams::class.java),
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
  fun onTextDocumentDidChange(doc: TextDocumentDidChangeParams): PublishDiagnosticsParams

  fun onTextDocumentCompletion(
      documentCompletionParams: TextDocumentCompletionParams
  ): LSPCompletionList
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

  @ToJson override fun toJson(writer: JsonWriter, value: JsonRPCRequest?) {}
}

class LSPServer(private val delegate: LSPDelegate) {
  private var initialized = false
  var channelFuture: ChannelFuture? = null
  val group: EventLoopGroup = NioEventLoopGroup()

  private val moshi =
      Moshi.Builder()
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
    val responseData: String? =
        try {
          if (!initialized && request.method != "initialize") {
            jsonRpc(
                adapter.toJson(
                    LSPResponse(
                        request.id,
                        null,
                        ResponseError(ErrorCode.ServerNotInitialized, "call initialize first"))))
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
                    delegate.onTextDocumentDidOpen(request.params as TextDocumentDidOpenParams)
                jsonRpc(
                    notifyAdapter.toJson(LSPNotification(LSPMethod.PublishDiagnotics.method, note)))
              }
              LSPMethod.TextDocumentDidChange -> {
                val note =
                    delegate.onTextDocumentDidChange(request.params as TextDocumentDidChangeParams)
                jsonRpc(
                    notifyAdapter.toJson(LSPNotification(LSPMethod.PublishDiagnotics.method, note)))
              }
              LSPMethod.TextDocumentDocumentSymbol -> {
                //                        val note =
                // delegate.onTextDocumentDocumentSymbol(request.params as
                // TextDocumentDocumentSymbolParams)
                //
                // jsonRpc(notifyAdapter.toJson(LSPNotification(LSPMethod.PublishDiagnotics.method,
                // note)))
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
                val response = delegate.onHover(request.params as HoverParams)
                jsonRpc(adapter.toJson(LSPResponse(request.id, response, null)))
              }
              LSPMethod.Shutdown -> {
                delegate.onShutdown()
                null
              }
              else -> null
            }
          }
        } catch (e: java.lang.Exception) {
          e.printStackTrace()
          jsonRpc(
              adapter.toJson(
                  LSPResponse(
                      request.id, null, ResponseError(ErrorCode.MethodNotFound), request.jsonrpc)))
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
    serverBootstrap.childHandler(
        object : ChannelInitializer<SocketChannel?>() {
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
    Header,
    Empty,
    Request
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

    @OptIn1(ExperimentalStdlibApi::class)
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
        capabilities =
            JsonRPCServerCapabilitiesImpl(
                textDocumentSync = TextDocumentSyncKind.Full, // TextDocumentSync(),
                completionProvider =
                    CompletionProvider(triggerCharacters = listOf("."), resolveProvider = true),
                workspace =
                    if (workspaceFolders)
                        WorkspaceFoldersServerCapabilities(WorkspaceFoldersCapabilities(true))
                    else null),
        serverInfo = LSPServerInfo("PineLang Server"))
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
    return LSPDiagnostic(Range(Position(0, 0), Position(0, 0)), 3, "")
  }

  override fun onTextDocumentDidChange(doc: TextDocumentDidChangeParams): PublishDiagnosticsParams {
    println("$doc")
    docItem =
        TextDocumentItem(
            uri = doc.textDocument.uri,
            languageId = "pine",
            text = doc.contentChanges[0].text,
            version = doc.textDocument.version)
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

    val propertyCompletionList =
        objType?.run {
          val type = pineEngine.types[objType] ?: return@run null
          (type.propNames() + listOf("id"))
              .filter { it != "children" }
              .filter { it.contains(incomplete) }
              .map {
                CompletionItem(
                    label = it,
                    insertText = "$it:",
                    detail = "Property",
                    kind = CompletionItemKind.Field.value)
              } +
              type.signalNames()
                  .filter { it.contains(incomplete) }
                  .map {
                    CompletionItem(
                        label = it,
                        insertText = "on $it:",
                        detail = "Signal",
                        kind = CompletionItemKind.Event.value)
                  } +
              type.callableNames()
                  .filter { it.contains(incomplete) }
                  .map {
                    CompletionItem(
                        label = it,
                        insertText = "$it()",
                        detail = "Function",
                        kind = CompletionItemKind.Function.value)
                  }
        }
            ?: listOf()

    val objCompletionList =
        pineEngine.types
            .index
            .keys
            .filter { it.contains(incomplete) }
            .map {
              CompletionItem(
                  label = "$it {", detail = "Type", kind = CompletionItemKind.Class.value)
            }
    return LSPCompletionList(
        isIncomplete = false, items = propertyCompletionList + objCompletionList)
  }

  override fun onHover(hover: HoverParams): HoverResponse? {
    println("onTextDocumentCompletion")
    if (docItem == null) return null
    val text = docItem!!.text
    val incomplete = text.getWordAtPosition(hover.position) ?: return null

    println("hovering on $incomplete")
    val range = Range(start = hover.position, end = hover.position)
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
          range = range)
    }

    return HoverResponse(MarkupContent("Don't know"), range = range)
  }

  private fun PineScriptParseException.toRange(): Range {
    return Range(
        Position(this.startLine - 1, this.startCol), Position(this.endLine - 1, this.endCol + 1))
  }

  private fun generateDiagnostic(script: String): PublishDiagnosticsParams {
    return try {
      val ast = pineEngine.compile(script)
      println("AST: $ast")
      PublishDiagnosticsParams(uri = docItem!!.uri, diagnostics = listOf())
    } catch (e: PineScriptParseException) {
      println("error: ${e.message}")
      PublishDiagnosticsParams(
          uri = docItem!!.uri,
          diagnostics =
              listOf(
                  LSPDiagnostic(
                      e.toRange(),
                      3,
                      severity = 1,
                      message = e.message!!,
                      source = "Pine Compiler")))
    }
  }
}
