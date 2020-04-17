package com.pinescript.lsp

import com.pinescript.lsp.LSPMethod.Companion.fromMethod
import com.pinescript.lsp.models.*
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.*
import io.ktor.util.cio.use
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.readUTF8Line
import io.ktor.utils.io.writeStringUtf8
import kotlinx.coroutines.*
import java.lang.RuntimeException
import java.net.InetSocketAddress

enum class LSPMethod(val method: String, val paramType: Class<*>) {
    Ignore("$", LSPEmptyParams::class.java),
    Initialize("initialize", LSPInitializeParams::class.java),
    Initialized("initialized", LSPEmptyParams::class.java),
    TextDocumentDidOpen("textDocument/didOpen", TextDocumentDidOpenParams::class.java),
    TextDocumentDidChange("textDocument/didChange", TextDocumentDidChangeParams::class.java),
    TextDocumentDocumentSymbol("textDocument/documentSymbol", TextDocumentDocumentSymbolParams::class.java),
    TextDocumentCompletion("textDocument/completion", TextDocumentCompletionParams::class.java),
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
    fun onTextDocumentDidOpen(doc: TextDocumentDidOpenParams): PublishDiagnosticsParams
    fun onTextDocumentDocumentSymbol(docIdentifier: TextDocumentDocumentSymbolParams): LSPDiagnostic
    fun onTextDocumentDidChange(didChangeTextDoc: TextDocumentDidChangeParams): PublishDiagnosticsParams
    fun onTextDocumentCompletion(documentCompletionParams: TextDocumentCompletionParams): LSPCompletionList
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

    private val moshi = Moshi.Builder().add(TextDocumentSyncKindAdapter()).add(KotlinJsonAdapterFactory()).build()

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
    override fun toJson(writer: JsonWriter, value: JsonRPCRequest?) {}
}

class LSPServer(private val delegate: LSPDelegate) {
    private var initialized = false
    private var job: Job? = null

    private val moshi = Moshi.Builder()
        .add(TextDocumentSyncKindAdapter())
        .add(LSPRequestAdapter())
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun jsonRPCRequest(data: ByteArray): JsonRPCRequest {
        val adapter = moshi.adapter(JsonRPCRequest::class.java)
        return adapter.fromJson(String(data))!!
    }

    private suspend fun handleRequest(request: JsonRPCRequest, output: ByteWriteChannel) {
        val error: ResponseError? = null
        val responseAdapter = moshi.adapter(LSPResponse::class.java).serializeNulls()
        val notifyAdapter = moshi.adapter(LSPNotification::class.java)
        val responseData: String? = try {
            if (!initialized && request.method != "initialize") {
                jsonRpc(responseAdapter.toJson(LSPResponse(
                    request.id,
                    null,
                    ResponseError(ErrorCode.ServerNotInitialized, "call initialize first")
                )))
            } else {
                when (fromMethod(request.method)) {
                    LSPMethod.Initialize -> {
                        initialized = true
                        val result = delegate.onInitialize(request.params as LSPInitializeParams)
                        val response = LSPResponse(request.id, result,null)
                        jsonRpc(responseAdapter.toJson(response))
                    }
                    LSPMethod.Initialized -> {
                        delegate.onInitialized()
                        null
                    }
                    LSPMethod.TextDocumentDidOpen -> {
                        val note = delegate.onTextDocumentDidOpen(request.params as TextDocumentDidOpenParams)
                        jsonRpc(notifyAdapter.toJson(LSPNotification(LSPMethod.PublishDiagnotics.method, note)))
                    }
                    LSPMethod.TextDocumentDidChange -> {
                        val note = delegate.onTextDocumentDidChange(request.params as TextDocumentDidChangeParams)
                        jsonRpc(notifyAdapter.toJson(LSPNotification(LSPMethod.PublishDiagnotics.method, note)))
                    }
                    LSPMethod.TextDocumentDocumentSymbol -> {
//                        val note = delegate.onTextDocumentDocumentSymbol(request.params as TextDocumentDocumentSymbolParams)
//                        jsonRpc(notifyAdapter.toJson(LSPNotification(LSPMethod.PublishDiagnotics.method, note)))
                        val response = LSPResponse(request.id, null,null)
                        jsonRpc(responseAdapter.toJson(response))
                    }
                    LSPMethod.TextDocumentCompletion -> {
                        val response = delegate.onTextDocumentCompletion(request.params as TextDocumentCompletionParams)
                        jsonRpc(responseAdapter.toJson(LSPResponse(request.id, response,null)))
                    }
                   LSPMethod.Shutdown -> {
                        delegate.onShutdown(); null
                    }
                    else -> null
                }

            }
        } catch (e: java.lang.Exception) {
            println("pvvpvp")
            e.printStackTrace()
            jsonRpc(responseAdapter.toJson(LSPResponse(request.id, null, ResponseError(ErrorCode.MethodNotFound), request.jsonrpc)))
        }
        println("response: $responseData\n")
        responseData?.run { output.writeStringUtf8(responseData) }
    }

    fun startServer(hostname: String = "localhost", port: Int = 2323) {
        job = GlobalScope.async(Dispatchers.IO) {
            val server = aSocket(ActorSelectorManager(Dispatchers.IO)).tcp()
                .bind(InetSocketAddress(hostname, port))


            println("LSP server started at ${server.localAddress}")

            server.use {
                while (isActive) {
                    val socket = server.accept()
                    launch {
                        println("Socket accepted: ${socket.remoteAddress}")

                        val input = socket.openReadChannel()
                        val output = socket.openWriteChannel(autoFlush = true)
                        output.use {
                            try {
                                while (true) {
                                    val headerStr = input.readUTF8Line()!!
                                    val header = jsonRPCHeader(headerStr)
                                    input.readUTF8Line() // next is empty
                                    println("request: header: $header")
                                    val body = ByteArray(header.contentLength)
                                    input.readFully(body, 0, header.contentLength)
                                    println("resquest: ${String(body)}\n")
                                    val request = jsonRPCRequest(body)
                                    handleRequest(request, output)
                                    if (request.method == "shutdown") {
                                        break
                                    }
                                }
                            } catch (e: Throwable) {
                                e.printStackTrace()
                            }
                        }
                    }
                }
            }
        }
    }

    fun isRunning(): Boolean = job?.isActive ?: false

    fun stopServer() {
        job?.cancel()
    }
    //fun response(method: String, params: Any?) = JsonRPCRequest(id++, method, params)
}