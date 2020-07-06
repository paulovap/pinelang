package com.pinescript.core

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

import com.google.flatbuffers.FlatBufferBuilder
import com.pinescript.ast.ProgramVisitor
import com.pinescript.ast.fbs.Program
import com.pinescript.parser.PineLexer
import com.pinescript.parser.PineScript
import com.pinescript.util.IndexedMap
import java.io.ByteArrayInputStream
import java.io.IOException
import java.nio.charset.StandardCharsets
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class PineContext {

    val refs: HashMap<Int, PineObject> = hashMapOf()

    fun registerObject(id: Int, obj: PineObject) {
        if (refs.containsKey(id))
            throw PineScriptException("object with id $id already defined: ${refs[id]}!")
        refs[id] = obj
    }

    fun clear() {
        refs.clear()
    }

    operator fun get(id: Int) = refs[id]
}

data class CompileObjectMetaData(val typeIdx: Int, val objId: Int, val objName: String)

class CustomFlatBufferBuilder(initialSize: Int) : FlatBufferBuilder(initialSize) {
    private val stringCache = mutableMapOf<CharSequence, Int>()

    override fun createString(s: CharSequence?): Int {
        if (s == null) return 0
        if (!stringCache.containsKey(s)) {
            return super.createString(s).also { stringCache[s] = it }
        }
        return stringCache[s]!!
    }

    override fun clear() {
        super.clear()
        stringCache.clear()
    }
}

@ExperimentalUnsignedTypes
class PineCompiler internal constructor(val types: IndexedMap<PineMetaObject>) {

    private var incrementalId: Int = 0
    private var ids: MutableMap<String, CompileObjectMetaData> = mutableMapOf()
    val flatBuilder = CustomFlatBufferBuilder(2048)

    fun objectMetaData(objectIdentifier: String) = ids[objectIdentifier]

    fun generateObjectId(typeId: Int, objectIdentifier: String?): Int {
        incrementalId++
        if (objectIdentifier != null)
            ids[objectIdentifier] = CompileObjectMetaData(typeId, incrementalId, objectIdentifier)
        return incrementalId
    }

    private val baseErrorListener = object : BaseErrorListener() {
        override fun syntaxError(
            recognizer: Recognizer<*, *>?,
            offendingSymbol: Any?,
            line: Int,
            charPositionInLine: Int,
            msg: String,
            e: RecognitionException?
        ) {
            if (offendingSymbol is CommonToken) {
                throw PineScriptParseException(
                    offendingSymbol.line,
                    offendingSymbol.charPositionInLine,
                    offendingSymbol.line,
                    offendingSymbol.charPositionInLine,
                    msg
                )
            } else {
                throw PineScriptException("syntax error: line $line:$charPositionInLine $msg")
            }
        }
    }

    fun compile(unit: String, keepDebugSymbols: Boolean = false): Program {
        try {
            flatBuilder.clear()
            val stream = ByteArrayInputStream(unit.toByteArray(StandardCharsets.UTF_8))
            val lexer = PineLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8))

            lexer.removeErrorListeners()
            lexer.addErrorListener(baseErrorListener)

            val tokens = CommonTokenStream(lexer)
            val parser = PineScript(tokens)

            parser.removeErrorListeners()
            parser.addErrorListener(baseErrorListener)

            val tree = parser.program()
            return ProgramVisitor(this, keepDebugSymbols).visit(tree)
        } catch (e: IOException) {
            throw PineScriptException("unable to load unit", e)
        }
    }
}
