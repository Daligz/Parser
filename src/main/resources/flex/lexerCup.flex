package me.upp.parser.generated;

import com.github.jhoenicke.javacup.runtime.Symbol;

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

( "=" ) { return new Symbol(sym.igu, yychar, yyline, yytext()); }
( "+" ) { return new Symbol(sym.sum, yychar, yyline, yytext()); }
( "-" ) { return new Symbol(sym.res, yychar, yyline, yytext()); }
( "/" ) { return new Symbol(sym.div, yychar, yyline, yytext()); }
{TXT}({TXT}|{VAL})* { return new Symbol(sym.id, yychar, yyline, yytext()); }
("(-"{VAL}+")")|{VAL}+ { return new Symbol(sym.id, yychar, yyline, yytext()); }
 . { return new Symbol(sym.error, yychar, yyline, yytext()); }
