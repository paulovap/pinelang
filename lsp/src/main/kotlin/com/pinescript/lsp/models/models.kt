package com.pinescript.lsp.models

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

enum class ErrorCode(val err: Int) {
    ParseError(-32700),
    InvalidRequest(-32600),
    MethodNotFound(-32601),
    InvalidParams(-32602),
    InternalError(-32603),
    ServerErrorStart(-32099),
    ServerErrorEnd(-32000),
    ServerNotInitialized(-32002),
    UnknownErrorCode(-32001),
    RequestCancelled(-32800),
    ContentModified(-32801)
}

fun jsonRpc(data: String): String = "Content-Length: ${data.length}\r\n\r\n$data"

data class ResponseError(
    val code: ErrorCode,
    val message: String? = null,
    val data: Any? = null
)

data class JsonRPCHeader(val contentLength: Int)

data class JsonRPCRequest(
    val jsonrpc: String,
    val id: Int? = null,
    val method: String,
    val params: Any? = null
)

data class LSPResponse(
    val id: Int?,
    val result: Any?,
    val error: ResponseError? = null,
    val jsonrpc: String = "2.0"
)

data class LSPNotification(
    /**
     * The method to be invoked.
     */
    val method: String,

    /**
     * The notification's params.
     */
    val params: Any?,
    val jsonrpc: String = "2.0"
)

data class JsonRPCClientInfo(val name: String, val version: String)

data class LSPClientInfo(val name: String, val version: String?)

class LSPEmptyParams

data class LSPInitializeParams(
    /**
     * The process Id of the parent process that started
     * the server.
     */
    val processId: Double?,
    /**
     * Information about the client
     *
     * @since 3.15.0
     */
    val clientInfo: LSPClientInfo?,
    /**
     * The rootPath of the workspace. Is null
     * if no folder is open.
     *
     * @deprecated in favour of rootUri.
     */
    val rootPath: String?,
    /**
     * The rootUri of the workspace. Is null if no
     * folder is open. If both `rootPath` and `rootUri` are set
     * `rootUri` wins.
     *
     * @deprecated in favour of workspaceFolders.
     */
    val rootUri: String?,
    /**
     * The capabilities provided by the client (editor or tool)
     */
    val capabilities: LSPClientCapabilities,
    /**
     * User provided initialization options.
     */
    val initializationOptions: Map<String, Any>?,
    /**
     * The initial trace setting. If omitted trace is disabled ('off').
     */
    val trace: String?
)

data class LSPClientCapabilities(
    /**
     * Workspace specific client capabilities.
     */
    val workspace: WorkspaceClientCapabilities?,
    /**
     * Text document specific client capabilities.
     */
    val textDocument: TextDocumentClientCapabilities?,
    /**
     * Window specific client capabilities.
     */
    val window: Any?,
    /**
     * Experimental client capabilities.
     */
    val experimental: Map<String, Any>?
)

/**
 * Text document specific client capabilities.
 */
data class TextDocumentClientCapabilities(
    /**
     * Defines which synchronization capabilities the client supports.
     */
    val synchronization: TextDocumentSyncClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/completion`
     */
    val completion: CompletionClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/hover`
     */
    val hover: HoverClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/signatureHelp`
     */
    val signatureHelp: SignatureHelpClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/declaration`
     *
     * @since 3.14.0
     */
    val declaration: DeclarationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/definition`
     */
    val definition: DeclarationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/typeDefinition`
     *
     * @since 3.6.0
     */
    val typeDefinition: DeclarationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/implementation`
     *
     * @since 3.6.0
     */
    val implementation: DeclarationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/references`
     */
    val references: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/documentHighlight`
     */
    val documentHighlight: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/documentSymbol`
     */
    val documentSymbol: DocumentSymbolClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/codeAction`
     */
    val codeAction: CodeActionClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/codeLens`
     */
    val codeLens: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/documentLink`
     */
    val documentLink: DocumentLinkClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/documentColor`
     */
    val colorProvider: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/formatting`
     */
    val formatting: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/rangeFormatting`
     */
    val rangeFormatting: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/onTypeFormatting`
     */
    val onTypeFormatting: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `textDocument/rename`
     */
    val rename: RenameClientCapabilities?,
    /**
     * Capabilities specific to `textDocument/foldingRange` requests.
     *
     * @since 3.10.0
     */
    val foldingRange: FoldingRangeClientCapabilities?,
    /**
     * Capabilities specific to `textDocument/selectionRange` requests
     *
     * @since 3.15.0
     */
    val selectionRange: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to `textDocument/publishDiagnostics`.
     */
    val publishDiagnostics: PublishDiagnosticsClientCapabilities?
)

data class PublishDiagnosticsClientCapabilities(
    /**
     * Whether the clients accepts diagnostics with related information.
     */
    val relatedInformation: Boolean?,
    /**
     * Client supports the tag property to provide meta data about a diagnostic.
     * Clients supporting tags have to handle unknown tags gracefully.
     *
     * @since 3.15.0
     */
    val tagSupport: ValueSet?,
    /**
     * Whether the client interprets the version property of the
     * `textDocument/publishDiagnostics` notification`s parameter.
     *
     * @since 3.15.0
     */
    val versionSupport: Boolean?
)

data class FoldingRangeClientCapabilities(
    /**
     * Whether implementation supports dynamic registration for folding range providers. If this is set to `true`
     * the client supports the new `FoldingRangeRegistrationOptions` return value for the corresponding server
     * capability as well.
     */
    val dynamicRegistration: Boolean?,
    /**
     * The maximum number of folding ranges that the client prefers to receive per document. The value serves as a
     * hint, servers are free to follow the limit.
     */
    val rangeLimit: Int?,
    /**
     * If set, the client signals that it only supports folding complete lines. If set, client will
     * ignore specified `startCharacter` and `endCharacter` properties in a FoldingRange.
     */
    val lineFoldingOnly: Boolean?
)

data class RenameClientCapabilities(
    /**
     * Whether rename supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * Client supports testing for validity of rename operations
     * before execution.
     *
     * @since version 3.12.0
     */
    val prepareSupport: Boolean?
)

data class DocumentLinkClientCapabilities(
    /**
     * Whether document link supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * Whether the client support the `tooltip` property on `DocumentLink`.
     *
     * @since 3.15.0
     */
    val tooltipSupport: Boolean
)

data class CodeActionClientCapabilities(
    /**
     * Whether code action supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * The client support code action literals as a valid
     * response of the `textDocument/codeAction` request.
     *
     * @since 3.8.0
     */
    val codeActionLiteralSupport: CodeActionLiteralSupport?,
    /**
     * Whether code action supports the `isPreferred` property.
     * @since 3.15.0
     */
    val isPreferredSupport: Boolean?
)

data class CodeActionLiteralSupport(
    /**
     * The code action kind is support with the following value
     * set.
     */
    val codeActionKind: Any?
)

data class DocumentSymbolClientCapabilities(
    /**
     * Whether document symbol supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * Specific capabilities for the `SymbolKind`.
     */
    val symbolKind: ValueSet?,
    /**
     * The client support hierarchical document symbols.
     */
    val hierarchicalDocumentSymbolSupport: Boolean?
)

data class DeclarationClientCapabilities(
    /**
     * Whether declaration supports dynamic registration. If this is set to `true`
     * the client supports the new `DeclarationRegistrationOptions` return value
     * for the corresponding server capability as well.
     */
    val dynamicRegistration: Boolean?,
    /**
     * The client supports additional metadata in the form of declaration links.
     */
    val linkSupport: Boolean?
)

/**
 * Client Capabilities for a [SignatureHelpRequest](#SignatureHelpRequest).
 */
data class SignatureHelpClientCapabilities(
    /**
     * Whether signature help supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * The client supports the following `SignatureInformation`
     * specific properties.
     */
    val signatureInformation: SignatureInformation?,
    /**
     * The client supports to send additional context information for a
     * `textDocument/signatureHelp` request. A client that opts into
     * contextSupport will also support the `retriggerCharacters` on
     * `SignatureHelpOptions`.
     *
     * @since 3.15.0
     */
    val contextSupport: Boolean?
)

data class SignatureInformation(
    val documentFormat: IntArray?,
    val parameterInformation: ParameterInformation
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SignatureInformation

        if (documentFormat != null) {
            if (other.documentFormat == null) return false
            if (!documentFormat.contentEquals(other.documentFormat)) return false
        } else if (other.documentFormat != null) return false
        if (parameterInformation != other.parameterInformation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = documentFormat?.contentHashCode() ?: 0
        result = 31 * result + parameterInformation.hashCode()
        return result
    }
}

data class ParameterInformation(val labelOffsetSupport: Boolean?)

data class HoverClientCapabilities(
    /**
     * Whether hover supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * Client supports the follow content formats for the content
     * property. The order describes the preferred format of the client.
     */
    val contentFormat: Array<String>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HoverClientCapabilities

        if (dynamicRegistration != other.dynamicRegistration) return false
        if (contentFormat != null) {
            if (other.contentFormat == null) return false
            if (!contentFormat.contentEquals(other.contentFormat)) return false
        } else if (other.contentFormat != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = dynamicRegistration?.hashCode() ?: 0
        result = 31 * result + (contentFormat?.contentHashCode() ?: 0)
        return result
    }
}

data class CompletionClientCapabilities(
    /**
     * Whether completion supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * The client supports the following `CompletionItem` specific
     * capabilities.
     */
    val completionItem: LSPCompletionItem?,
    val completionItemKind: ValueSet?,
    /**
     * The client supports to send additional context information for a
     * `textDocument/completion` requestion.
     */
    val contextSupport: Boolean?
)

data class LSPCompletionItem(
    /**
     * Client supports snippets as insert text.
     *
     * A snippet can define tab stops and placeholders with `$1`, `$2`
     * and `${3:foo}`. `$0` defines the final tab stop, it defaults to
     * the end of the snippet. Placeholders with equal identifiers are linked,
     * that is typing in one will update others too.
     */
    val snippetSupport: Boolean?,
    /**
     * Client supports commit characters on a completion item.
     */
    val commitCharactersSupport: Boolean?,
    /**
     * Client supports the follow content formats for the documentation
     * property. The order describes the preferred format of the client.
     */
    val documentationFormat: Array<String>?,
    /**
     * Client supports the deprecated property on a completion item.
     */
    val deprecatedSupport: Boolean?,
    /**
     * Client supports the preselect property on a completion item.
     */
    val preselectSupport: Boolean?,
    /**
     * Client supports the tag property on a completion item. Clients supporting
     * tags have to handle unknown tags gracefully. Clients especially need to
     * preserve unknown tags when sending a completion item back to the server in
     * a resolve call.
     *
     * @since 3.15.0
     */
    val tagSupport: ValueSet?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LSPCompletionItem

        if (snippetSupport != other.snippetSupport) return false
        if (commitCharactersSupport != other.commitCharactersSupport) return false
        if (deprecatedSupport != other.deprecatedSupport) return false
        if (preselectSupport != other.preselectSupport) return false
        if (tagSupport != other.tagSupport) return false

        return true
    }

    override fun hashCode(): Int {
        var result = snippetSupport?.hashCode() ?: 0
        result = 31 * result + (commitCharactersSupport?.hashCode() ?: 0)
        result = 31 * result + (deprecatedSupport?.hashCode() ?: 0)
        result = 31 * result + (preselectSupport?.hashCode() ?: 0)
        result = 31 * result + (tagSupport?.hashCode() ?: 0)
        return result
    }
}

data class TextDocumentSyncClientCapabilities(
    /**
     * Whether text document synchronization supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * The client supports sending will save notifications.
     */
    val willSave: Boolean?,
    /**
     * The client supports sending a will save request and
     * waits for a response providing text edits which will
     * be applied to the document before it is saved.
     */
    val willSaveWaitUntil: Boolean?,
    /**
     * The client supports did save notifications.
     */
    val didSave: Boolean?
)

data class WorkspaceClientCapabilities(
    /**
     * The client supports applying batch edits
     * to the workspace by supporting the request
     * 'workspace/applyEdit'
     */
    val applyEdit: Boolean?,
    /**
     * Capabilities specific to `WorkspaceEdit`s
     */
    val workspaceEdit: WorkspaceEditClientCapabilities?,
    /**
     * Capabilities specific to the `workspace/didChangeConfiguration` notification.
     */
    val didChangeConfiguration: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `workspace/didChangeWatchedFiles` notification.
     */
    val didChangeWatchedFiles: ConfigurationClientCapabilities?,
    /**
     * Capabilities specific to the `workspace/symbol` request.
     */
    val symbol: WorkspaceSymbolClientCapabilities?,
    /**
     * Capabilities specific to the `workspace/executeCommand` request.
     */
    val executeCommand: ConfigurationClientCapabilities?,

    /**
     * The client has support for workspace folders
     */
    val workspaceFolders: Boolean?
)

enum class LSPResourceOperation { create, rename, delete }

enum class LSPFailureHandling { abort, transactional, undo, textOnlyTransactional }

data class WorkspaceEditClientCapabilities(
    /**
     * The client supports versioned document changes in `WorkspaceEdit`s
     */
    val documentChanges: Boolean,
    /**
     * The resource operations the client supports. Clients should at least
     * support 'create', 'rename' and 'delete' files and folders.
     *
     * @since 3.13.0
     */
    val resourceOperations: List<LSPResourceOperation>?,
    /**
     * The failure handling strategy of a client if applying the workspace edit
     * fails.
     *
     * @since 3.13.0
     */
    val failureHandling: LSPFailureHandling?
)

data class WorkspaceSymbolClientCapabilities(
    /**
     * Symbol request supports dynamic registration.
     */
    val dynamicRegistration: Boolean?,
    /**
     * Specific capabilities for the `SymbolKind` in the `workspace/symbol` request.
     */
    val symbolKind: ValueSet?
)

data class ValueSet(val valueSet: IntArray?) {
    /**
     * The symbol kind values the client supports. When this
     * property exists the client also guarantees that it will
     * handle values outside its set gracefully and falls back
     * to a default value when unknown.
     *
     * If this property is not present the client only supports
     * the symbol kinds from `File` to `Array` as defined in
     * the initial version of the protocol.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ValueSet

        if (valueSet != null) {
            if (other.valueSet == null) return false
            if (!valueSet.contentEquals(other.valueSet)) return false
        } else if (other.valueSet != null) return false

        return true
    }

    override fun hashCode(): Int {
        return valueSet?.contentHashCode() ?: 0
    }
}

data class ConfigurationClientCapabilities(
    /**
     * Did change configuration notification supports dynamic registration.
     */
    val dynamicRegistration: Boolean?
)

data class CompletionProvider(
    val triggerCharacters: List<String>? = null,
    val resolveProvider: Boolean = true
)

// change: 1 is non-incremental, 2 is incremental
data class TextDocumentSync(
    val openClose: Boolean = true,
    val change: Int = 1,
    val save: Map<String, Any> = mapOf("includeText" to true)
)

data class LSPServerInfo(val name: String, val version: String? = null)
data class LSPInitializeServerResult(
    val capabilities: JsonRPCServerCapabilitiesImpl,
    val serverInfo: LSPServerInfo
)

class TextDocumentSyncKindAdapter : JsonAdapter<TextDocumentSyncKind>() {

    @FromJson
    override fun fromJson(reader: JsonReader): TextDocumentSyncKind? {
        return when (reader.nextInt()) {
            0 -> TextDocumentSyncKind.None
            1 -> TextDocumentSyncKind.Full
            2 -> TextDocumentSyncKind.Incremental
            else -> TextDocumentSyncKind.None
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: TextDocumentSyncKind?) {
        writer.value(
            when (value) {
                TextDocumentSyncKind.None -> 0
                TextDocumentSyncKind.Full -> 1
                TextDocumentSyncKind.Incremental -> 2
                else -> 0
            }
        )
    }
}

enum class TextDocumentSyncKind(val int: Int) {
    /**
     * Documents should not be synced at all.
     */
    None(0),

    /**
     * Documents are synced by always sending the full content
     * of the document.
     */
    Full(1),

    /**
     * Documents are synced by sending the full content on open.
     * After that only incremental updates to the document are
     * send.
     */
    Incremental(2)
}

data class JsonRPCServerCapabilitiesImpl(
    val completionProvider: CompletionProvider = CompletionProvider(),
    val definitionProvider: Boolean = true,
    val textDocumentSync: TextDocumentSyncKind = TextDocumentSyncKind.Full,
    val hoverProvider: Boolean = true,
    val documentSymbolProvider: Boolean = true,
    val workspace: WorkspaceFoldersServerCapabilities? = null
)

data class WorkspaceFoldersServerCapabilities(
    val workspaceFolders: WorkspaceFoldersCapabilities? = null
)

data class WorkspaceFoldersCapabilities(
    val supported: Boolean = false,
    val changeNotification: String? = null
)
