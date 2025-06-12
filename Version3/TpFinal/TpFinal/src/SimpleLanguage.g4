grammar SimpleLanguage;

// REGLAS SINTÁCTICAS
start: statement EOF;

statement: 
    'if' condition 'then' statement 'else' statement  # IfStatement
    | assignment                                       # AssignmentStatement
    ;

condition:
    expression RELOP expression    # RelationalCondition
    | 'true'                      # TrueCondition
    | 'false'                     # FalseCondition
    ;

expression:
    expression '+' term    # AddExpression
    | term                 # TermExpression
    ;

term:
    factor              # FactorTerm
    | term '*' factor   # MultiplyTerm
    ;

factor:
    ID                    # IdFactor
    | NUM                 # NumFactor
    | '(' expression ')'  # ParenFactor
    ;

assignment:
    ID ':=' expression
    ;

// TOKENS LÉXICOS
ID: [a-zA-Z][a-zA-Z0-9]*;
NUM: [0-9]+;
RELOP: '==' | '!=' | '<' | '<=' | '>' | '>=';

// PALABRAS CLAVE
IF: 'if';
THEN: 'then';
ELSE: 'else';
TRUE: 'true';
FALSE: 'false';

// OPERADORES Y DELIMITADORES
ASSIGN: ':=';
PLUS: '+';
MULTIPLY: '*';
LPAREN: '(';
RPAREN: ')';

// ESPACIOS EN BLANCO (IGNORAR)
WS: [ \t\r\n]+ -> skip;

// COMENTARIOS (IGNORAR)
COMMENT: '//' ~[\r\n]* -> skip;