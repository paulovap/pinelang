package com.flex.ast

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

import com.flex.ast.statement.ScriptStatementVisitor
import com.flex.core.*
import com.flex.parser.QMLParser
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

class PropertyVisitor(engine: QMLEngine, parentContext: QMLContext?, private val owner: QMLObject) :
    QMLVisitor<QMLProperty>(engine, parentContext) {

    override fun visitDeclaredPropertyScriptStatement(ctx: QMLParser.DeclaredPropertyScriptStatementContext?): QMLProperty {
        //TODO: how do we know if the binding result can be casted to the property?
        val propName = ctx!!.JsIdentifier().text
        val prop = owner.declaredProperties.firstOrNull { it.name == propName } ?:
        throw QMLRuntimeException(null,
            "type %s does not have declared property %s",
            owner::class.qualifiedName,
            propName)
        val binding = ScriptStatementVisitor(engine, context, owner).visit(ctx.scriptStatement())

        return QMLBindedProperty(ctx.JsIdentifier().text, prop.kClass, binding, false)
    }

    override fun visitPropertyDeclaration(ctx: QMLParser.PropertyDeclarationContext): QMLProperty {
        val clazz = castQMLType(ctx.propertyType().text)
        return QMLProperty(ctx.JsIdentifier().text, clazz, null, true)
    }

    override fun visitPropertyDeclarationAndAssignObjectDefinition(ctx: QMLParser.PropertyDeclarationAndAssignObjectDefinitionContext): QMLProperty {
        val propertyType = ctx.propertyType().text
        val clazz = castQMLType(propertyType)

        if (!clazz.isSubclassOf(QMLObject::class)) {
            throw QMLRuntimeException("Invalid property type in object assignment")
        }

        //@TODO verify if object declared in property have parent assigned
        val initialValue = ObjectDefinitionVisitor(engine, context, null).visit(ctx.objectDefinition())
        return QMLProperty(ctx.JsIdentifier().text, clazz, initialValue, true)
    }

    override fun visitPropertyDeclarationAndAssignScriptStatement(ctx: QMLParser.PropertyDeclarationAndAssignScriptStatementContext): QMLProperty {
        val propertyType = ctx.propertyType().text
        val clazz = castQMLType(propertyType)
        val binding = ScriptStatementVisitor(engine, context, owner).visit(ctx.scriptStatement())
        return QMLBindedProperty(ctx.JsIdentifier().text, clazz, binding, true)
    }

    private fun castQMLType(type: String): KClass<*> {

        return engine.getKClass(type) ?: throw QMLRuntimeException("type %s is not defined", type)
    }
}
