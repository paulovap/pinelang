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

/** The kind of a completion entry. */
enum class CompletionItemKind(val value: Int) {
  Text(1),
  Method(2),
  Function(3),
  Constructor(4),
  Field(5),
  Variable(6),
  Class(7),
  Interface(8),
  Module(9),
  Property(10),
  Unit(11),
  Value(12),
  Enum(13),
  Keyword(14),
  Snippet(15),
  Color(16),
  File(17),
  Reference(18),
  Folder(19),
  EnumMember(20),
  Constant(21),
  Struct(22),
  Event(23),
  Operator(24),
  TypeParameter(25)
}

/** Represents a collection of [completion items](#CompletionItem) to be presented in the editor. */
data class LSPCompletionList(
    /** This list it not complete. Further typing should result in recomputing this list. */
    val isIncomplete: Boolean = false,

    /** The completion items. */
    val items: List<CompletionItem>)

data class CompletionItem(
    /**
     * The label of this completion item. By default also the text that is inserted when selecting
     * this completion.
     */
    val label: String,

    /**
     * The kind of this completion item. Based of the kind an icon is chosen by the editor. The
     * standardized set of available values is defined in `CompletionItemKind`.
     */
    val kind: Int? = null,

    /**
     * A human-readable string with additional information about this item, like type or symbol
     * information.
     */
    val detail: String? = null,

    /** A human-readable string that represents a doc-comment. */
    val documentation: String? = null,

    /**
     * Indicates if this item is deprecated.
     *
     * @deprecated Use `tags` instead if supported.
     */
    val deprecated: Boolean? = null,

    /**
     * Select this item when showing.
     *
     * *Note* that only one completion item can be selected and that the tool / client decides which
     * item that is. The rule is that the *first* item of those that match best is selected.
     */
    val preselect: Boolean? = false,

    /**
     * A string that should be used when comparing this item with other items. When `falsy` the
     * label is used.
     */
    val sortText: String? = null,

    /**
     * A string that should be used when filtering a set of completion items. When `falsy` the label
     * is used.
     */
    val filterText: String? = null,

    /**
     * A string that should be inserted into a document when selecting this completion. When `falsy`
     * the label is used.
     *
     * The `insertText` is subject to interpretation by the client side. Some tools might not take
     * the string literally. For example VS Code when code complete is requested in this example
     * `con<cursor position>` and a completion item with an `insertText` of `console` is provided it
     * will only insert `sole`. Therefore it is recommended to use `textEdit` instead since it
     * avoids additional client side interpretation.
     */
    val insertText: String? = null,

    /**
     * The format of the insert text. The format applies to both the `insertText` property and the
     * `newText` property of a provided `textEdit`. If omitted defaults to
     * `InsertTextFormat.PlainText`. 1: The primary text to be inserted is treated as a plain
     * string. 2: The primary text to be inserted is treated as a snippet.
     *
     * A snippet can define tab stops and placeholders with `$1`, `$2` and `${3:foo}`. `$0` defines
     * the final tab stop, it defaults to the end of the snippet. Placeholders with equal
     * identifiers are linked, that is typing in one will update others too.
     */
    val insertTextFormat: Int? = null,

    /**
     * An edit which is applied to a document when selecting this completion. When an edit is
     * provided the value of `insertText` is ignored.
     *
     * *Note:* The range of the edit must be a single line range and it must contain the position at
     * which completion has been requested.
     */
    val textEdit: TextEdit? = null,

    /**
     * An optional array of additional text edits that are applied when selecting this completion.
     * Edits must not overlap (including the same insert position) with the main edit nor with
     * themselves.
     *
     * Additional text edits should be used to change text unrelated to the current cursor position
     * (for example adding an import statement at the top of the file if the completion item will
     * insert an unqualified type).
     */
    val additionalTextEdits: List<TextEdit>? = null,

    /**
     * An optional set of characters that when pressed while this completion is active will accept
     * it first and then type that character. *Note* that all commit characters should have
     * `length=1` and that superfluous characters will be ignored.
     */
    val commitCharacters: List<String>? = null,

    /**
     * An optional command that is executed *after* inserting this completion. *Note* that
     * additional modifications to the current document should be described with the
     * additionalTextEdits-property.
     */
    val command: Command? = null,

    /**
     * A data entry field that is preserved on a completion item between a completion and a
     * completion resolve request.
     */
    val data: Any? = null)

data class TextEdit(
    /**
     * The range of the text document to be manipulated. To insert text into a document create a
     * range where start === end.
     */
    val range: Range,

    /** The string to be inserted. For delete operations use an empty string. */
    val newText: String)

data class Command(
    /** Title of the command, like `save`. */
    val title: String,
    /** The identifier of the actual command handler. */
    val command: String,
    /** Arguments that the command handler should be invoked with. */
    val arguments: List<Any>?)
