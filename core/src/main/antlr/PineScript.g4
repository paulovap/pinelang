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

parser grammar PineScript;

options { tokenVocab = PineLexer; }

@header {
    package org.pinelang.parser;
}

///////////////////////////
// Parser rules
///////////////////////////

program
    : rootMember EOF
    ;

rootMember
    : objectDefinition;

objectDefinition
    : ObjectType objectInitializer SEMICOLON?
    ;

// { ... }
objectInitializer
    : LBRACE objectIdentifier?
    ( objectDefinition
    | signalAssignement
    | propertyDefinition)* RBRACE
    ;

objectIdentifier
    : ID COLON Identifier SEMICOLON?
    ;

objectMember
    : objectDefinition
    | signalAssignement
    | propertyDefinition
    ;

signalAssignement
    : ON Identifier COLON callableExpression SEMICOLON?
    ;
// prop: ... ;
propertyDefinition
    : Identifier COLON expression SEMICOLON?
    ;

expression
    : primitiveExpression
    | objectPropertyExpression
    | expression binaryOperation expression
    | callableExpression
    ;

binaryOperation
    : PLUS       // start number values only
    | MINUS
    | MULTI
    | DIV
    | REMAINDER  // end number values only
    | AND        // start boolean values only
    | OR         // end boolean values only
    ;
// height: width;
// height: otherObject.width;
objectPropertyExpression
    : Identifier (DOT Identifier)?
    ;

// visible: true
// width: 100
// text: "Asdf"
primitiveExpression
    : TRUE
    | FALSE
    | IntegerLiteral integerSuffix?
    | FloatLiteral
    | stringLiteral
    ;

stringLiteral
    : DOUBLE_QUOTE_OPEN STRING DOUBLE_QUOTE_CLOSE
    ;

integerSuffix
    : SUFFIX_DP | SUFFIX_PX
    ;

callableExpression
//    : Identifier LPAREN arguments? RPAREN
    : Identifier LPAREN RPAREN
    ;

arguments
    : expression ( ',' expression )*
    ;