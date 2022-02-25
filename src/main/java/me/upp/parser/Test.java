package me.upp.parser;

import org.yuanheng.cookcc.CookCCOption;
import org.yuanheng.cookcc.Lex;
import org.yuanheng.cookcc.Lexs;

@CookCCOption(lexerTable = "compressed", parserTable = "compressed")
public class Test extends Parser {

    @Lex(pattern = "([a-zA-Z]+)|([0-9]+)", token = "ID")
    protected String parseId() {
        return yyText();
    }

    @Lexs(patterns = {
        @Lex (pattern = "[=]", token = "ASSIGN"),
        @Lex (pattern = "[+]", token = "ADD"),
        @Lex (pattern = "\\-", token = "SUB"),
        @Lex (pattern = "[/]", token = "DIV"),
    })
    protected Object parseOp() {
        return null;
    }

    @Lex (pattern = "<<EOF>>", token = "$")
    protected void parseEOF () { }
}
