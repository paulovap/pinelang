///////////////////////////
// Lexer Rules
///////////////////////////
lexer grammar PineLexer;

@header {
    package org.pinelang.parser;
}

// Something to keep in mind
// Lexer always pattern matching the rule in order
// so first rule will always match
ON: 'on';
SUFFIX_DP: 'dp';
SUFFIX_PX: 'px';
ID : 'id';
DOT : '.';
LPAREN : '(';
RPAREN : ')';
COMMA : ',';
NULL : 'null';
TRUE : 'true';
FALSE : 'false';
EQ : '=';
LBRACKET : '[';
RBRACKET : ']';
AND_AND : '&&';
OR_OR : '||';
QUESTION : '?';
SEMICOLON : ';' ;
COLON  : ':' ;
LBRACE : '{' ;
RBRACE : '}' ;
RETURN : 'return';
IMPORT : 'import' ;
PLUS: '+';
MINUS: '-';
MULTI: '*';
DIV: '/';
REMAINDER: '%';
AND: 'and';
OR: 'or';

Identifier: [a-z][a-zA-Z_0-9]*;

ObjectType: [A-Z][a-zA-Z_]*;

DOUBLE_QUOTE_OPEN: '"' -> pushMode(LineString);

mode LineString;

DOUBLE_QUOTE_CLOSE: '"' -> popMode;

STRING
   : (ESC | SAFECODEPOINT)*
   ;

fragment ESC
   : '\\' (["\\/bfnrt] | UNICODE)
   ;

fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;

fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;

fragment HEX
   : [0-9a-fA-F]
   ;


mode DEFAULT_MODE;

IntegerLiteral
    : DecimalIntegerLiteral
    ;

FloatLiteral
    : DecimalIntegerLiteral '.' [0-9]* ExponentPart?
    | '.' [0-9]+ ExponentPart?
    ;

fragment DecimalIntegerLiteral
    : [0-9]+
    ;
fragment ExponentPart
    : [eE] [+-]? [0-9]+
    ;
// chars that need to be skipped
WS : [ \t\r\n;] -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT :   '//' ~[\r\n]* -> skip;

LineTerminator: [\r\n\u2028\u2029] -> channel(HIDDEN);
