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
}
