package com.pinescript.main

import com.pinescript.ast.fbs.ObjectDefinition
import com.pinescript.ast.fbs.PropDefinition
import com.pinescript.ast.fbs.SignalExpr
import com.pinescript.core.*
import java.lang.Thread.sleep
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

class Item(id: Int) : PineObject(id) {
    companion object {
        val meta = PineMetaObject("Item") { Item(it) }
    }
    val int1: Int by intProp(::int1)
    val int2: Int by intProp(::int2)
    val int3: Int by intProp(::int3)
    val int4: Int by intProp(::int4)

    val str1: String by stringProp(::str1)
    val str2: String by stringProp(::str2)
    val str3: String by stringProp(::str3)
    val str4: String by stringProp(::str4)
    override fun getMeta(): PineMetaObject = meta
}


fun main() {
    val engine = PineEngine.Builder().registerPineType(Item.meta).build()
    val script = """
        Item { id: test; int1: 20
            //on mount: printHello()
            //on mount: printHello()
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: test.int1 + 20; int2: 20 + 20; int3: 200; int4: test.int1; str1: "asdf";  str2: "asdf";  str3: "asdf";  str4: "asdf";  }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
            Item{ int1: test.int1 + 20; on mount: helloText() }
        }
    """.trimIndent()
    //val obj = engine.load(script, true) as Item
//    println(obj.a)
//    obj.dispose()
    benchmarkWhole(script, engine)
    //println("Walk time  ${measureTimeMillis { walkProgram(program.root!!) } } ms")
    //benchmark(script, engine)
    //benchmarkWalk(script, engine)
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
//    while (true) {
//        sleep(1000)
//    }
//    println(obj)
//    val myList = (0..10000).map { it }.toList()
//    myList.forEach { println(it) }
}

fun benchmarkWhole(script: String, engine: PineEngine) {
    val compiled = engine.compile(script, false)
    val times = 10000
    val warmupTimes = 1000
    repeat(warmupTimes) { engine.load(script) }

    var totalCompile = measureTimeMillis { repeat(times) { engine.compile(script, false) } }
    println("compile $times in total $totalCompile ms avg ${totalCompile/times.toDouble()} ms")

    var totalEval = measureTimeMillis { repeat(times) { engine.eval(compiled) } }
    println("eval $times in total $totalEval ms avg ${totalEval/times.toDouble()} ms")

    var total = totalCompile + totalEval
    println("compile + eval $times in total $total ms avg ${total/times.toDouble()} ms")
}

fun benchmark(script: String, engine: PineEngine) {
    repeat(10) { engine.compile(script) }
    val times = 100000
    val total = measureTimeMillis { repeat(times) { engine.compile(script, false) } }
    println("run $times in total $total ms avg ${total/times.toDouble()} ms")
}

fun benchmarkWalk(script: String, engine: PineEngine) {
    val program = engine.compile(script, false)
    val root = program.root!!
    repeat(100) { walkProgram(root) }
    val times = 100000
    val total = measureTimeMillis { repeat(times) {
        walkProgram(
            root
        )
    } }
    println("run $times in total $total ms avg ${total/times.toDouble()} ms")
}

fun walkProgram(objectDefinition: ObjectDefinition) {
    val obj = ObjectDefinition()
    val prop = PropDefinition()
    val signal = SignalExpr()

    for (i in 0 until objectDefinition.childrenLength) {
        walkProgram(objectDefinition.children(obj, i)!!)
    }

    for (i in 0 until objectDefinition.propsLength) {
        objectDefinition.props(prop, i)
    }

    for (i in 0 until objectDefinition.signalsLength) {
        objectDefinition.signals(signal, i)
    }
}