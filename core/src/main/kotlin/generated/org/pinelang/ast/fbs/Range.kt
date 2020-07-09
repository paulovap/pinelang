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
package org.pinelang.ast.fbs

import com.google.flatbuffers.*
import java.nio.*
import kotlin.math.sign

@Suppress("unused")
@ExperimentalUnsignedTypes
class Range : Struct() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): Range {
    __init(_i, _bb)
    return this
  }
  val start: org.pinelang.ast.fbs.Position?
    get() = start(org.pinelang.ast.fbs.Position())
  fun start(obj: org.pinelang.ast.fbs.Position): org.pinelang.ast.fbs.Position? =
      obj.__assign(bb_pos + 0, bb)
  val end: org.pinelang.ast.fbs.Position?
    get() = end(org.pinelang.ast.fbs.Position())
  fun end(obj: org.pinelang.ast.fbs.Position): org.pinelang.ast.fbs.Position? =
      obj.__assign(bb_pos + 8, bb)
  companion object {
    fun createRange(
        builder: FlatBufferBuilder, start_line: Int, start_char: Int, end_line: Int, end_char: Int
    ): Int {
      builder.prep(4, 16)
      builder.prep(4, 8)
      builder.putInt(end_char)
      builder.putInt(end_line)
      builder.prep(4, 8)
      builder.putInt(start_char)
      builder.putInt(start_line)
      return builder.offset()
    }
  }
}
