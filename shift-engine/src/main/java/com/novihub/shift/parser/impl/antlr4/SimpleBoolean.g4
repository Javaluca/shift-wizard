grammar SimpleBoolean;

parse
 : expression EOF
 ;
 
argument
 : IDENTIFIER ;
 
arguments
 : argument
 | left=arguments COMMA right=argument
 ; 
 
predicate
 : IDENTIFIER
 | IDENTIFIER LPAREN RPAREN
 | IDENTIFIER LPAREN arguments RPAREN
 ;


expression
 : predicate									  #predicateExpression
 | LPAREN expression RPAREN                       #parenExpression
 | NOT expression                            	  #notExpression
 | EXCLAMATION_MARK expression                    #notExpression
 | left=expression op=binary right=expression     #binaryExpression
 ;


binary
 : AND | OR
 ;
 

COMMA	   : ',';
AND        : 'AND' ;
OR         : 'OR' ;
NOT        : 'NOT';
EXCLAMATION_MARK: '!';
LPAREN     : '(' ;
RPAREN     : ')' ;
IDENTIFIER : [a-zA-Z_0-9]+ ;
WS         : [ \r\t\u000C\n]+ -> skip;