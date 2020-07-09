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

/** Selection range for a document. End position is exclusive */
data class Range(val start: Position, val end: Position)

data class Location(val uri: String, val range: Range)

data class DiagnosticRelatedInformation(
    /** The location of this related diagnostic information. */
    val location: Location,

    /** The message of this related diagnostic information. */
    val message: String)

data class PublishDiagnosticsParams(
    /** The URI for which diagnostic information is reported. */
    val uri: String,
    /**
     * Optional the version number of the document the diagnostics are published for.
     *
     * @since 3.15.0
     */
    val version: Double? = null,
    /** An array of diagnostic information items. */
    val diagnostics: List<LSPDiagnostic>)

data class LSPDiagnostic(
    /** The range at which the message applies. */
    val range: Range,

    /** The diagnostic's code, which might appear in the user interface. */
    val code: Int,

    /** The diagnostic's message. */
    val message: String,

    /**
     * The diagnostic's severity. Can be omitted. If omitted it is up to the client to interpret
     * diagnostics as error, warning, info or hint.
     *
     * 1: Reports an error. 2: Reports a warning. 3: Reports an information.
     */
    val severity: Int? = null,

    /**
     * A human-readable string describing the source of this diagnostic, e.g. 'typescript' or 'super
     * lint'.
     */
    val source: String? = null,

    /**
     * An array of related diagnostic information, e.g. when symbol-names within a scope collide all
     * definitions can be marked via this property.
     */
    val relatedInformation: List<DiagnosticRelatedInformation>? = null)
