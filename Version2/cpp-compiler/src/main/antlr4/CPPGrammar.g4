grammar CPPGrammar;

// ========== ANÁLISIS LÉXICO ==========

// Palabras clave
INT         : 'int';
CHAR        : 'char';
DOUBLE      : 'double';
VOID        : 'void';
IF          : 'if';
ELSE        : 'else';
FOR         : 'for';
WHILE       : 'while';
BREAK       : 'break';
CONTINUE    : 'continue';
RETURN      : 'return';

// Operadores aritméticos
PLUS        : '+';
MINUS       : '-';
MULTIPLY    : '*';
DIVIDE      : '/';
MODULO      : '%';
ASSIGN      : '=';

// Operadores de comparación
EQ          : '==';
NE          : '!=';
LT          : '<';
LE          : '<=';
GT          : '>';
GE          : '>=';

// Operadores lógicos
AND         : '&&';
OR          : '||';
NOT         : '!';

// Incremento/Decremento
INCREMENT   : '++';
DECREMENT   : '--';

// Delimitadores
SEMICOLON   : ';';
COMMA       : ',';
LPAREN      : '(';
RPAREN      : ')';
LBRACE      : '{';
RBRACE      : '}';

// Literales
INTEGER     : [0-9]+;
CHAR_LITERAL: '\'' (~['\\\r\n] | EscapeSequence) '\'';
DOUBLE_LITERAL: [0-9]+ '.' [0-9]+;

// Identificadores
IDENTIFIER  : [a-zA-Z_][a-zA-Z0-9_]*;

// Secuencias de escape
fragment EscapeSequence
    : '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

fragment HexDigit
    : [0-9a-fA-F]
    ;

// Espacios en blanco y comentarios
WS          : [ \t\r\n]+ -> skip;
COMMENT     : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

// ========== ANÁLISIS SINTÁCTICO ==========

// Programa principal
program
    : (declaration | functionDeclaration)* EOF
    ;

// Declaraciones
declaration
    : variableDeclaration
    | functionDeclaration
    ;

variableDeclaration
    : dataType IDENTIFIER (ASSIGN expression)? SEMICOLON
    ;

functionDeclaration
    : dataType IDENTIFIER LPAREN parameterList? RPAREN block
    ;

parameterList
    : parameter (COMMA parameter)*
    ;

parameter
    : dataType IDENTIFIER
    ;

// Tipos de datos
dataType
    : INT
    | CHAR
    | DOUBLE
    | VOID
    ;

// Bloque de código
block
    : LBRACE statement* RBRACE
    ;

// Sentencias
statement
    : variableDeclaration
    | assignmentStatement
    | ifStatement
    | whileStatement
    | forStatement
    | breakStatement
    | continueStatement
    | returnStatement
    | expressionStatement
    | block
    ;

assignmentStatement
    : IDENTIFIER ASSIGN expression SEMICOLON
    ;

ifStatement
    : IF LPAREN expression RPAREN statement (ELSE statement)?
    ;

whileStatement
    : WHILE LPAREN expression RPAREN statement
    ;

forStatement
    : FOR LPAREN (variableDeclaration | assignmentStatement | SEMICOLON) 
          expression? SEMICOLON 
          expression? RPAREN statement
    ;

breakStatement
    : BREAK SEMICOLON
    ;

continueStatement
    : CONTINUE SEMICOLON
    ;

returnStatement
    : RETURN expression? SEMICOLON
    ;

expressionStatement
    : expression SEMICOLON
    ;

// Expresiones
expression
    : logicalOrExpression
    ;

logicalOrExpression
    : logicalAndExpression (OR logicalAndExpression)*
    ;

logicalAndExpression
    : equalityExpression (AND equalityExpression)*
    ;

equalityExpression
    : relationalExpression ((EQ | NE) relationalExpression)*
    ;

relationalExpression
    : additiveExpression ((LT | LE | GT | GE) additiveExpression)*
    ;

additiveExpression
    : multiplicativeExpression ((PLUS | MINUS) multiplicativeExpression)*
    ;

multiplicativeExpression
    : unaryExpression ((MULTIPLY | DIVIDE | MODULO) unaryExpression)*
    ;

unaryExpression
    : (PLUS | MINUS | NOT) unaryExpression
    | postfixExpression
    ;

postfixExpression
    : primaryExpression (INCREMENT | DECREMENT)?
    ;

primaryExpression
    : IDENTIFIER
    | INTEGER
    | CHAR_LITERAL
    | DOUBLE_LITERAL
    | LPAREN expression RPAREN
    | functionCall
    ;

functionCall
    : IDENTIFIER LPAREN argumentList? RPAREN
    ;

argumentList
    : expression (COMMA expression)*
    ;