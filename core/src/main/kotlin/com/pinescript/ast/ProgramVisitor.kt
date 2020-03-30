package com.pinescript.ast

/*
BSD License

Copyright (c) 2018, ${user}
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

import com.pinescript.ast.fbs.Program
import com.pinescript.core.PineCompiler
import com.pinescript.core.PineEngine
import com.pinescript.core.PineMetaObject
import com.pinescript.parser.PineScriptParser
import com.pinescript.util.IndexedMap
import java.nio.ByteBuffer

@ExperimentalUnsignedTypes
class ProgramVisitor(compiler: PineCompiler, debug: Boolean) : PineScriptVisitor<Program>(compiler, debug) {

    val objectDefinitionVisitor = ObjectDefinitionVisitor(compiler, debug)

    override fun visitProgram(ctx: PineScriptParser.ProgramContext): Program {
        val objPos = objectDefinitionVisitor.visit(ctx.rootMember().objectDefinition())
        fb.finish(Program.createProgram(fb, objPos))
        return Program.getRootAsProgram(fb.dataBuffer())
    }
}
