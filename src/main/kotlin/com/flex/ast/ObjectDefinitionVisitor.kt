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
import com.flex.parser.QMLParser

import java.lang.reflect.InvocationTargetException
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties

class ObjectDefinitionVisitor(engine: QMLEngine, parentContext: QMLContext?, private val parent: QMLObject?) :
    QMLVisitor<QMLObject>(engine, parentContext) {

    override fun visitObjectDefinition(ctx: QMLParser.ObjectDefinitionContext): QMLObject? {

        val type = ctx.JsIdentifier().text

        val kClass = engine.getKClass(type)
            ?: //@TODO: throw line number
            throw QMLRuntimeException("%s is not a type", type)

        try {
            val obj = kClass.createInstance() as QMLObject

            if (parent != null) {
                obj.setParent(parent)
            }

            // add getChildren
            for (memberCtx in ctx.objectInitializer().objectMember()) {

                /* getChildren parsing */
                if (memberCtx.objectDefinition() != null) {
                    ObjectDefinitionVisitor(engine, context, obj).visit(memberCtx.objectDefinition())
                }

                /* declared properties parsing */
                if (memberCtx.propertyDeclaration() != null) {
                    val prop = PropertyVisitor(engine, context, obj).visit(memberCtx.propertyDeclaration())
                    obj.addDynamicProperty(prop)
                }

                /* declared properties with object */
                if (memberCtx.propertyDeclarationAndAssignObjectDefinition() != null) {
                    val prop = PropertyVisitor(
                        engine,
                        context,
                        obj
                    ).visit(memberCtx.propertyDeclarationAndAssignObjectDefinition())
                    obj.addDynamicProperty(prop)
                }

                /* declared properties with script */
                if (memberCtx.propertyDeclarationAndAssignScriptStatement() != null) {
                    val prop = PropertyVisitor(
                        engine,
                        context,
                        obj
                    ).visit(memberCtx.propertyDeclarationAndAssignScriptStatement())
                    obj.addDynamicProperty(prop)
                }

                /* assigning script to a declared property */
                if (memberCtx.declaredPropertyScriptStatement() != null) {
                    val prop = PropertyVisitor(
                        engine,
                        context,
                        obj
                    ).visit(memberCtx.declaredPropertyScriptStatement())
                    obj.declaredProperties.replaceAll { if (it.name == prop.name) prop else it }
                }
            }
            return obj
        } catch (e: InstantiationException) {
            throw QMLRuntimeException(
                e, "%s unable to be instantiated",
                kClass.qualifiedName
            )
        } catch (e: IllegalAccessException) {
            throw QMLRuntimeException(
                e, "%s constructor not implemented",
                kClass.qualifiedName
            )
        } catch (e: ClassCastException) {
            throw QMLRuntimeException(
                e, "%s does not implement %s",
                kClass.qualifiedName,
                QMLObject::class.qualifiedName
            )
        } catch (e: NoSuchMethodException) {
            throw QMLRuntimeException(
                e, "%s does not implement mandatory constructor %s(QMLObject parent);",
                kClass.qualifiedName,
                kClass.qualifiedName
            )
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        return null
    }
}
