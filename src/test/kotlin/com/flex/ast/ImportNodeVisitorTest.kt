package com.flex.ast

import org.antlr.v4.runtime.misc.ParseCancellationException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.io.IOException

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
class ImportNodeVisitorTest {


    private val acceptables =
        arrayOf("import QtQuick 1.0;", "import 'http://www.google.com' 0.2;", "import QtQuick.Controls 2.3;")

    private val errorImport =
        arrayOf("import 3 1.0", "import QtQuick;", "import QtQuick T.T as Good", "import QtQuick 1.1 as 10")

    private val acceptableResults = arrayOf(
        ImportNode("QtQuick", 1.0),
        ImportNode("'http://www.google.com'", 0.2),
        ImportNode("QtQuick.Controls", 2.3)
    )

    @Test
    @Throws(IOException::class)
    fun testValidImportVisitor() {
        for (i in acceptables.indices) {
            val tree = LoadTree.loadTree(acceptables[i]).import_()
            val importVisitor = ImportVisitor()
            val import = importVisitor.visit(tree)
            assertEquals(acceptableResults[i], import)
        }
    }

    @Test
    @Throws(IOException::class)
    fun testInValidImportVisitor() {
        for (code in errorImport) {
            try {
                val tree = LoadTree.loadTree(code).import_()
                val importVisitor = ImportVisitor()
                val import = importVisitor.visit(tree)
                assertNull("This assert should never been reached because visitor should throw exception", import)
            } catch (ignored: ParseCancellationException) {
            }

        }
    }
}