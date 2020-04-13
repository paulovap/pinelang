package com.pinescript.lsp

import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.util.KtorExperimentalAPI
import io.ktor.utils.io.readUTF8Line
import io.ktor.utils.io.writeStringUtf8
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.junit.Test
import java.net.InetSocketAddress
import kotlin.test.assertEquals

class LSPTest {

//    @Test fun testCapabilities() {
////        val server = LSPServer()
////        assertEquals(ErrorCode.ServerNotInitialized, server.handleRequest(JsonRPCRequest(1, "test")).error!!.code)
////        val result = server.handleRequest(JsonRPCRequest(1, "initialize"))
////        assertEquals(JsonRPCClientInfoCapabilities(), result.result)
//    }
//
//    @KtorExperimentalAPI
//    @Test fun testTcpConnectivity() {
//        val server = LSPServer()
//        server.startServer(port=12345)
//        // Wait for coroutines a bit
//        Thread.sleep(100)
//        assertEquals(true, server.isRunning())
//        runBlocking {
//            withTimeout(2000) {
//                val socket = aSocket(ActorSelectorManager(Dispatchers.IO)).tcp().connect(InetSocketAddress("localhost", 12345))
//                val input = socket.openReadChannel()
//                val output = socket.openWriteChannel(autoFlush = true)
//
//                output.writeStringUtf8(makeRequest(1, "initialize"))
//                val response = input.readUTF8Line()
//                println("Server said: '$response'")
//            }
//        }
//        server.stopServer()
//    }
}