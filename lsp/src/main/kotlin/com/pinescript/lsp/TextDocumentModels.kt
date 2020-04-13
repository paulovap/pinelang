package com.pinescript.lsp

data class TextDocumentDidOpenParams(val textDocument: TextDocumentItem)

data class TextDocumentItem(
    /**
     * The text document's URI.
     */
    val uri: String,

    /**
     * The text document's language identifier.
     */
    val languageId: String,

    /**
     * The version number of this document (it will increase after each
     * change, including undo/redo).
     */
    val version: Double,

    /**
     * The content of the opened text document.
     */
    val text: String
)

data class TextDocumentDocumentSymbolParams(val textDocument: TextDocumentIdentifier)

data class TextDocumentIdentifier (
    /**
     * The text document's URI.
     */
    val uri: String
)

data class TextDocumentDidChangeParams (
    /**
     * The document that did change. The version number points
     * to the version after all provided content changes have
     * been applied.
     */
    val textDocument: VersionedTextDocumentIdentifier,

    /**
     * The actual content changes. The content changes describe single state changes
     * to the document. So if there are two content changes c1 (at array index 0) and
     * c2 (at array index 1) for a document in state S then c1 moves the document from
     * S to S' and c2 from S' to S''. So c1 is computed on the state S and c2 is computed
     * on the state S'.
     *
     * To mirror the content of a document using change events use the following approach:
     * - start with the same initial content
     * - apply the 'textDocument/didChange' notifications in the order you recevie them.
     * - apply the `TextDocumentContentChangeEvent`s in a single notification in the order
     *   you receive them.
     */
    val contentChanges: List<TextDocumentContentChangeEvent>
)

data class TextDocumentContentChangeEvent(val text: String)

data class VersionedTextDocumentIdentifier(
    /**
     * The version number of this document. If a versioned text document identifier
     * is sent from the server to the client and the file is not open in the editor
     * (the server has not received an open notification before) the server can send
     * `null` to indicate that the version is known and the content on disk is the
     * master (as speced with document content ownership).
     *
     * The version number of a document will increase after each change, including
     * undo/redo. The number doesn't need to be consecutive.
     */
    val version: Double,
    /**
     * The text document's URI.
     */
    val uri: String
)

data class TextDocumentCompletionParams(
    /**
     * The text document.
     */
    val textDocument: TextDocumentIdentifier,
    /**
     * The position inside the text document.
     */
    val position: Position,
    val context: CompletionContext
)

data class Position(val line: Int, val character: Int)

data class CompletionContext (
    /**
     * How the completion was triggered.
     * 1: Completion was triggered by typing an identifier (24x7 code
     * complete), manual invocation (e.g Ctrl+Space) or via API.
     * 2: Completion was triggered by a trigger character specified by
     * the `triggerCharacters` properties of the `CompletionRegistrationOptions`.
     * 3: Completion was re-triggered as current completion list is incomplete
     */
    val triggerKind: Int,
    /**
     * The trigger character (a single character) that has trigger code complete.
     * Is undefined if `triggerKind !== CompletionTriggerKind.TriggerCharacter`
     */
    val triggerCharacter: String?
)

