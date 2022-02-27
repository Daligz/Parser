package me.upp.parser.generated;

import me.upp.parser.Tokens;

%%
%class Lexer
%type Tokens
TXT = [a-zA-Z_]+
VAL = [0-9]+
spaces = [ ,\t,\r]+
%{
    public String lexeme;
%}
%%

{spaces} {/*Ignore*/}

( "=" ) {lexeme=yytext(); return Tokens.IGU;}
( "+" ) {lexeme=yytext(); return Tokens.SUM;}
( "-" ) {lexeme=yytext(); return Tokens.RES;}
( "/" ) {lexeme=yytext(); return Tokens.DIV;}
{TXT}({TXT}|{VAL})* {lexeme=yytext(); return Tokens.ID;}
("(-"{VAL}+")")|{VAL}+ {lexeme=yytext(); return Tokens.ID;}
 . {return Tokens.ERR;}
