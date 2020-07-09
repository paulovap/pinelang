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
package org.pinelang.lsp

class LSPTest {

  //    @Test fun testCapabilities() {
  // //        val server = LSPServer()
  // //        assertEquals(ErrorCode.ServerNotInitialized, server.handleRequest(JsonRPCRequest(1,
  // "test")).error!!.code)
  // //        val result = server.handleRequest(JsonRPCRequest(1, "initialize"))
  // //        assertEquals(JsonRPCClientInfoCapabilities(), result.result)
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
  //                val socket =
  // aSocket(ActorSelectorManager(Dispatchers.IO)).tcp().connect(InetSocketAddress("localhost",
  // 12345))
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
