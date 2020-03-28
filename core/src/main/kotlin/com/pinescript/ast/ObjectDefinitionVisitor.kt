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

package com.pinescript.ast

import com.pinescript.core.*
import com.pinescript.parser.PineScriptParser

class ObjectDefinitionVisitor(engine: PineEngine, rootContext: PineContext) :
    PineScriptVisitor<PineObject>(engine, rootContext) {

    override fun visitObjectDefinition(ctx: PineScriptParser.ObjectDefinitionContext): PineObject? {

        val type = ctx.ObjectDeclaration().text

        val obj = engine.getAllocator(type)(-1)

        val initContext = ctx.objectInitializer()

        initContext.objectIdentifier()?.also { rootContext.registerObject(it.Identifier().text, obj) }

        initContext.objectMember().forEach {
            /* getChildren parsing */

            if (it.objectDefinition() != null) {
                val newObject = ObjectDefinitionVisitor(engine, rootContext).visit(it.objectDefinition())
                obj.children.add(newObject)
            }

            /* assigning script to a declared property */
            if (it.propertyAssignement() != null) {
                PropertyVisitor(engine, rootContext, obj).visit(it.propertyAssignement())
            }

            it.signalAssignement()?.also { sigCtx ->
                val name = sigCtx.Identifier().text
                val sig = obj.signals[name] ?: throw PineScriptParseException(sigCtx.COLON(), "Signal $name not found int $obj")
                sig.connect { ExpressionVisitor(engine, rootContext, obj).visit(sigCtx.callableExpression())() }
            }
        }

        obj.emitMount()
        return obj
    }
}
