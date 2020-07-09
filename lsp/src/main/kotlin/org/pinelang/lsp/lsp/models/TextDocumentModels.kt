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
package org.pinelang.lsp.lsp.models

data class TextDocumentDidOpenParams(val textDocument: TextDocumentItem)

data class HoverParams(
    /** The text document. */
    val textDocument: TextDocumentIdentifier,

    /** The position inside the text document. */
    val position: Position)

/** The result of a hover request. */
data class HoverResponse(
    /** The hover's content */
    val contents: MarkupContent,

    /**
     * An optional range is a range inside a text document that is used to visualize a hover, e.g.
     * by changing the background color.
     */
    val range: Range)

data class MarkupContent(
    val value: String,
    // export type MarkupKind = 'plaintext' | 'markdown';
    val kind: String = "markdown")

data class TextDocumentItem(
    /** The text document's URI. */
    val uri: String,

    /** The text document's language identifier. */
    val languageId: String,

    /**
     * The version number of this document (it will increase after each change, including
     * undo/redo).
     */
    val version: Double,

    /** The content of the opened text document. */
    val text: String)

data class TextDocumentSymbolParams(val textDocument: TextDocumentIdentifier)

data class TextDocumentIdentifier(
    /** The text document's URI. */
    val uri: String)

data class TextDocumentDidChangeParams(
    /**
     * The document that did change. The version number points to the version after all provided
     * content changes have been applied.
     */
    val textDocument: VersionedTextDocumentIdentifier,

    /**
     * The actual content changes. The content changes describe single state changes to the
     * document. So if there are two content changes c1 (at array index 0) and c2 (at array index 1)
     * for a document in state S then c1 moves the document from S to S' and c2 from S' to S''. So
     * c1 is computed on the state S and c2 is computed on the state S'.
     *
     * To mirror the content of a document using change events use the following approach:
     * - start with the same initial content
     * - apply the 'textDocument/didChange' notifications in the order you recevie them.
     * - apply the `TextDocumentContentChangeEvent`s in a single notification in the order you
     * receive them.
     */
    val contentChanges: List<TextDocumentContentChangeEvent>)

data class TextDocumentContentChangeEvent(val text: String)

data class VersionedTextDocumentIdentifier(
    /**
     * The version number of this document. If a versioned text document identifier is sent from the
     * server to the client and the file is not open in the editor (the server has not received an
     * open notification before) the server can send `null` to indicate that the version is known
     * and the content on disk is the master (as speced with document content ownership).
     *
     * The version number of a document will increase after each change, including undo/redo. The
     * number doesn't need to be consecutive.
     */
    val version: Double,
    /** The text document's URI. */
    val uri: String)

data class TextDocumentCompletionParams(
    /** The text document. */
    val textDocument: TextDocumentIdentifier,
    /** The position inside the text document. */
    val position: Position,
    val context: CompletionContext)

data class Position(val line: Int, val character: Int)

data class CompletionContext(
    /**
     * How the completion was triggered. 1: Completion was triggered by typing an identifier (24x7
     * code complete), manual invocation (e.g Ctrl+Space) or via API. 2: Completion was triggered by
     * a trigger character specified by the `triggerCharacters` properties of the
     * `CompletionRegistrationOptions`. 3: Completion was re-triggered as current completion list is
     * incomplete
     */
    val triggerKind: Int,
    /**
     * The trigger character (a single character) that has trigger code complete. Is undefined if
     * `triggerKind !== CompletionTriggerKind.TriggerCharacter`
     */
    val triggerCharacter: String?)

fun String.charIndexAtPosition(pos: Position): Int? {
  var lineRemaining = 0
  forEachIndexed { i, it ->
    if (it == '\n') {
      lineRemaining++
    }

    if (lineRemaining == pos.line) {
      val index = i + pos.character
      return if (index < length) index else null
    }
  }
  return null
}

fun String.getWordAtPosition(pos: Position): String? {
  val charPos = this.charIndexAtPosition(pos) ?: return null
  val pattern = Regex("\\w+")
  var startIndex = 0

  while (true) {
    val match = pattern.find(this, startIndex) ?: return null

    if (charPos >= match.range.first && charPos <= match.range.last) {
      return match.value
    }
    startIndex = match.range.last + 1
  }
}

fun String.getNextWordToRight(charPos: Int): String? {
  val pattern = Regex("\\w+")
  var lastMatch: String? = null
  var match = pattern.find(this, 0) ?: return null
  while (true) {
    lastMatch =
        when {
          match.range.last == charPos -> return match.value
          match.range.last <= charPos -> match.value
          else -> return lastMatch
        }

    match = match.next() ?: return null
  }
}

/**
 * If position is inside a object delimited by Type { .. } This function will return the object
 * type.
 */
fun String.getObjectTypeEnclosingPosition(pos: Position): String? {
  var charPos = this.charIndexAtPosition(pos) ?: return null
  var bracketBalance = 0
  while (charPos >= 0) {
    val c = this[charPos]
    when {
      c == '{' && bracketBalance == 0 -> return getNextWordToRight(charPos - 1)
      c == '{' && bracketBalance != 0 -> bracketBalance++
      c == '}' -> bracketBalance--
    }
    charPos--
  }
  return null
}
