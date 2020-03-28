package com.flex.lsp

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.*
import io.ktor.util.cio.use
import io.ktor.utils.io.read
import io.ktor.utils.io.readUTF8Line
import io.ktor.utils.io.readUntilDelimiter
import io.ktor.utils.io.writeStringUtf8
import kotlinx.coroutines.*
import java.net.InetSocketAddress

enum class ErrorCode(val err: Int) {
    ParseError(-32700),
    InvalidRequest(-32600),
    MethodNotFound(-32601),
    InvalidParams(-32602),
    InternalError(-32603),
    ServerErrorStart(-32099),
    ServerErrorEnd(-32000),
    ServerNotInitialized(-32002),
    UnknownErrorCode(-32001),
    RequestCancelled(-32800),
    ContentModified(-32801)
}

fun jsonRpc(data: String): String = "Content-Length: ${data.length}\r\n\r\n${data}"

data class ResponseError(
    val code: ErrorCode,
    val message: String? = null,
    val data: Any? = null
)
data class Request(val id: Int, val method: String, val params: Any? = null)

data class Response (
    val id: Int,
    val result: Any?,
    val error: ResponseError? = null,
    val jsonrpc: String = "2.0"
)

data class CompletionProvider(val triggerCharacters: List<String>, val resolveProvider: Boolean = false)

//change: 1 is non-incremental, 2 is incremental
data class TextDocumentSync(
    val openClose: Boolean = true,
    val change: Int = 1,
    val save: Map<String, Any> = mapOf("includeText" to true)
)

data class Capabilities(
    val completionProvider: CompletionProvider = CompletionProvider(listOf("."), false),
    val definitionProvider: Boolean = true,
    val textDocumentSync: TextDocumentSync = TextDocumentSync(),
    val hoverProvider: Boolean = true,
    val documentSymbolProvider: Boolean = true
)

fun makeRequest(id: Int, method: String, params: Any? = null): String {
    val moshi = Moshi.Builder()
        // ... add your own JsonAdapters and factories ...
        .add(KotlinJsonAdapterFactory())
        .build()
    val adapter = moshi.adapter(Request::class.java)
    val request = adapter.toJson(Request(id, method, params))
    return jsonRpc(request)
}

class LSPServer {
    private var initialized = false
    private var job: Job? = null

    fun handleRequest(request: Request): Response {

        if (!initialized && request.method != "initialize") {
            return Response(request.id, null, ResponseError(ErrorCode.ServerNotInitialized, "call initialize first"))
        }

        return when(request.method) {
            "initialize" -> initialize(request.id)
            else -> Response(request.id, null, ResponseError(ErrorCode.MethodNotFound, request.method))
        }
    }

    fun initialize(id: Int) : Response = Response(id, Capabilities()).also { initialized = true }

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
                                    val header = input.readUTF8Line() // this is header
                                    println("${socket.remoteAddress}: $header")
                                    input.readUTF8Line() // next is empty
                                    val body = ByteArray(30)
                                    input.readFully(body, 0,30)
                                    println(String(body))
                                    output.writeStringUtf8("Test\r\n")
                                }
                            } catch (e: Throwable) {
                                //e.printStackTrace()
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