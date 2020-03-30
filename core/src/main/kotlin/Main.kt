import com.pinescript.core.PineEngine
import com.pinescript.core.PineMetaObject
import com.pinescript.core.PineObject
import com.pinescript.core.intProp
import io.ktor.util.KtorExperimentalAPI
import kotlin.system.measureTimeMillis


/*
BSD License

Copyright (c) 2018, Paulo Pinheiro
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
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


class Item(id: Long) : PineObject(id) {
    companion object {
        val meta = PineMetaObject("Item") { Item(it) }
    }
    val a: Int by intProp(::a)
}
@KtorExperimentalAPI
fun main(argv: Array<String>) {
    val engine = PineEngine.Builder().registerPineType(Item.meta).build()
    val script = """
        Item { id: test; a: 20
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
            Item{ a: test.a + 20; on mount: helloText() }
        }
    """.trimIndent()
    // warmup
    repeat(10) { engine.compile(script) }
    val times = 100000
    val total = measureTimeMillis { repeat(times) { engine.compile(script, false) } }
    println("run $times in total $total ms avg ${total/times.toDouble()} ms")

//    val program = engine.compile(script, false)
//    val releaseBytes = engine.compiler.flatBuilder.sizedByteArray()
//    val programDebug = engine.compile(script, true)
//    val debugBytes = engine.compiler.flatBuilder.sizedByteArray()
//    println("scriptSize ${script.toByteArray().size/1024} kb")
//    println("compiledSize ${releaseBytes.size/1024} kb")
//    println("compiledSizeDebug ${debugBytes.size/1024} kb")
//    println(measureTimeMillis {
//        repeat(times) {
//            engine.compile(script)
//        }
//    } / times.toDouble())
}