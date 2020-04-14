package com.pinescript.lsp

enum class SymbolKind(val value: Int) {
    File(1),
    Module(2),
    Namespace(3),
    Package(4),
    Class(5),
    Method(6),
    Property(7),
    Field(8),
    Constructor(9),
    Enum(10),
    Interface(11),
    Function(12),
    Variable(13),
    Constant(14),
    String(15),
    Number(16),
    Boolean(17),
    Array(18),
    Object(19),
    Key(20),
    Null(21),
    EnumMember(22),
    Struct(23),
    Event(24),
    Operator(25),
    TypeParameter(26),
}


/**
 * Represents programming constructs like variables, classes, interfaces etc. that appear in a document. Document symbols can be
 * hierarchical and they have two ranges: one that encloses its definition and one that points to its most interesting range,
 * e.g. the range of an identifier.
 */
data class DocumentSymbol(
    /**
     * The name of this symbol. Will be displayed in the user interface and therefore must not be
     * an empty string or a string only consisting of white spaces.
     */
    val name: String,

    /**
     * More detail for this symbol, e.g the signature of a function.
     */
    val detail: String,

    /**
     * The kind of this symbol.
     */
    val kind: SymbolKind,

    /**
     * Indicates if this symbol is deprecated.
     */
    val deprecated: Boolean?,

    /**
     * The range enclosing this symbol not including leading/trailing whitespace but everything else
     * like comments. This information is typically used to determine if the clients cursor is
     * inside the symbol to reveal in the symbol in the UI.
     */
    val range: Range,

    /**
     * The range that should be selected and revealed when this symbol is being picked, e.g the name of a function.
     * Must be contained by the `range`.
     */
    val selectionRange: Range,

    /**
     * Children of this symbol, e.g. properties of a class.
     */
    val children: List<DocumentSymbol>?
)

/**
 * Represents information about programming constructs like variables, classes,
 * interfaces etc.
 */
data class SymbolInformation(
    /**
     * The name of this symbol.
     */
    val name: String,

    /**
     * The kind of this symbol.
     */
    val kind: SymbolKind,

    /**
     * Indicates if this symbol is deprecated.
     */
    val deprecated: Boolean?,

    /**
     * The location of this symbol. The location's range is used by a tool
     * to reveal the location in the editor. If the symbol is selected in the
     * tool the range's start information is used to position the cursor. So
     * the range usually spans more then the actual symbol's name and does
     * normally include things like visibility modifiers.
     *
     * The range doesn't have to denote a node range in the sense of a abstract
     * syntax tree. It can therefore not be used to re-construct a hierarchy of
     * the symbols.
     */
    val location: Location,

    /**
     * The name of the symbol containing this symbol. This information is for
     * user interface purposes (e.g. to render a qualifier in the user interface
     * if necessary). It can't be used to re-infer a hierarchy for the document
     * symbols.
     */
    val containerName: String?
)