package me.upp.parser;

import org.yuanheng.cookcc.CookCCOption;
import org.yuanheng.cookcc.Lex;

@CookCCOption(lexerTable = "compressed", parserTable = "compressed")
public class Test extends Parser {

    @Lex(pattern = "([a-zA-Z]+)|([0-9]+)", token = "ID")
    protected String parseId() {
        return yyText();
    }

    @Lex(pattern = "\\+", token = "PLUS")
    protected String parsePlus() {
        return yyText();
    }

    @Lex(pattern = "\\-", token = "MINUS")
    protected String parseMinus() {
        return yyText();
    }

    @Lex(pattern = "\\/", token = "DIV")
    protected String parseDiv() {
        return yyText();
    }

    @Lex(pattern = "\\=", token = "EQUALS")
    protected String parseEquals() {
        return yyText();
    }

    @Lex (pattern = "<<EOF>>", token = "$")
    protected void parseEOF () { }
}
