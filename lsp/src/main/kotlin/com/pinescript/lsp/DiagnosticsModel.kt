package com.pinescript.lsp

/**
 * Selection range for a document. End position is exclusive
 */
data class Range(
    val start: Position,
    val end: Position
)

data class Location(
    val uri: String,
    val range: Range
)

data class DiagnosticRelatedInformation(
    /**
     * The location of this related diagnostic information.
     */
    val location: Location,

    /**
     * The message of this related diagnostic information.
     */
    val message: String
)

data class PublishDiagnosticsParams (
    /**
     * The URI for which diagnostic information is reported.
     */
    val uri: String,
    /**
     * Optional the version number of the document the diagnostics are published for.
     *
     * @since 3.15.0
     */
    val version: Double? = null,
    /**
     * An array of diagnostic information items.
     */
    val diagnostics: List<LSPDiagnostic>
)

data class LSPDiagnostic(
    /**
     * The range at which the message applies.
     */
    val range: Range,

    /**
     * The diagnostic's code, which might appear in the user interface.
     */
    val code: Int,

    /**
     * The diagnostic's message.
     */
    val message: String,

    /**
     * The diagnostic's severity. Can be omitted. If omitted it is up to the
     * client to interpret diagnostics as error, warning, info or hint.
     *
     * 1: Reports an error.
     * 2: Reports a warning.
     * 3: Reports an information.
     */
    val severity: Int? = null,

    /**
     * A human-readable string describing the source of this
     * diagnostic, e.g. 'typescript' or 'super lint'.
     */
    val source: String? = null,

    /**
     * An array of related diagnostic information, e.g. when symbol-names within
     * a scope collide all definitions can be marked via this property.
     */
    val relatedInformation: List<DiagnosticRelatedInformation>? = null
)