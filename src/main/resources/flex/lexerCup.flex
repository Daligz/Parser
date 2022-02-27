package me.upp.parser.generated;

import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
TXT = [a-zA-Z_]+
VAL = [0-9]+
spaces = [ ,\t,\r, \n]+
%{
    private Symbol symbol(int type, Object value) {
      return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type) {
      return new Symbol(type, yyline, yycolumn);
    }
%}
%%

{spaces} {/*Ignore*/}

( "=" ) { return new Symbol(sym.igu, (int) yychar, yyline, yytext()); }
( "+" ) { return new Symbol(sym.sum, (int) yychar, yyline, yytext()); }
( "-" ) { return new Symbol(sym.res, (int) yychar, yyline, yytext()); }
( "/" ) { return new Symbol(sym.div, (int) yychar, yyline, yytext()); }
{TXT}({TXT}|{VAL})* { return new Symbol(sym.id, (int) yychar, yyline, yytext()); }
("(-"{VAL}+")")|{VAL}+ { return new Symbol(sym.id, (int) yychar, yyline, yytext()); }
 . { return new Symbol(sym.error, (int) yychar, yyline, yytext()); }
