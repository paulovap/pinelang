/*
BSD License

Copyright (c) $today.year, Paulo Pinheiro
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
