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

package com.flex.ast

import com.flex.core.*
import com.flex.parser.PineScriptParser

import java.lang.reflect.InvocationTargetException

class ObjectDefinitionVisitor(engine: PineEngine, val rootContext: PineContext) :
    PineScriptVisitor<PineObject>(engine) {

    override fun visitObjectDefinition(ctx: PineScriptParser.ObjectDefinitionContext): PineObject? {

        val type = ctx.ObjectDeclaration().text

        val obj = engine.getAllocator(type)(-1)

        if (ctx.objectInitializer().objectIdentifier() != null) {
            val identifier = ctx.objectInitializer().objectIdentifier().Identifier()
            try {
                rootContext.registerObject(identifier.text, obj)
            } catch (e: PineScriptException) {
                throw PineScriptParseException(identifier, e)
            }
        }

        for (memberCtx in ctx.objectInitializer().objectMember()) {

            /* getChildren parsing */
            if (memberCtx.objectDefinition() != null) {
                obj.addChild(ObjectDefinitionVisitor(engine, rootContext).visit(memberCtx.objectDefinition()))
            }


            /* assigning script to a declared property */
            if (memberCtx.propertyAssignement() != null) {
                PropertyVisitor(engine, rootContext, obj).visit(memberCtx.propertyAssignement())
            }
        }
        return obj
    }
}
