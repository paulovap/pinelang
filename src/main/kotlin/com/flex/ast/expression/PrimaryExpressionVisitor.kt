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

package com.flex.ast.expression

import com.flex.core.QMLContext
import com.flex.core.QMLEngine
import com.flex.core.QMLObject
import com.flex.core.QMLRuntimeException
import com.flex.core.expression.QMLExpression
import com.flex.core.expression.QMLPrimaryExpression
import com.flex.parser.QMLParser

import java.text.NumberFormat
import java.text.ParseException

class PrimaryExpressionVisitor(engine: QMLEngine, parentContext: QMLContext?, owner: QMLObject) :
    ExpressionVisitor(engine, parentContext, owner) {

    override fun visitPrimaryExpression(ctx: QMLParser.PrimaryExpressionContext): QMLExpression {

        var value: Any? = null

        when {
            ctx.THIS() != null -> value = owner
            ctx.TRUE() != null -> value = java.lang.Boolean.TRUE
            ctx.FALSE() != null -> value = java.lang.Boolean.FALSE
            ctx.StringLiteral() != null -> value = ctx.StringLiteral().text.substring(1, ctx.StringLiteral().text.length - 1)
            ctx.NumericLiteral() != null -> try {
                value = NumberFormat.getInstance().parse(ctx.NumericLiteral().text)
            } catch (e: ParseException) {
                throw QMLRuntimeException("Number %s cannot be parsed", ctx.NumericLiteral().text)
            }
            ctx.JsIdentifier() != null -> value = context.fetch(ctx.JsIdentifier().text)
        }
        return QMLPrimaryExpression(context, owner, value)
    }
}
