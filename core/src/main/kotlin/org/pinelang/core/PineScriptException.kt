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
package org.pinelang.core

import org.antlr.v4.runtime.Token
import org.pinelang.ast.fbs.BinaryOp

class PineScriptParseException(
    val startLine: Int,
    val startCol: Int,
    val endLine: Int,
    val endCol: Int,
    message: String = "",
    cause: Throwable? = null
) : RuntimeException("\n$message at line: $startLine col: $startCol", cause) {

  constructor(startToken: Token, endToken: Token, message: String = "", cause: Throwable? = null
  ) : this(
      startToken.line,
      startToken.charPositionInLine,
      endToken.line,
      endToken.charPositionInLine,
      message,
      cause)
}

open class PineScriptException(msg: String, cause: Throwable? = null) :
    RuntimeException(msg, cause)

class BinaryOpNotSupportedPineScriptException(op: UByte, type: PineType) :
    PineScriptException("operation ${BinaryOp.name(op.toInt())} not supported for $type")

class BinaryOpException(op: UByte, typeA: PineType, typeB: PineType) :
    PineScriptException(
        "unable to apply operator '${BinaryOp.name(op.toInt())}' " +
            "with types $typeA and $typeB")
