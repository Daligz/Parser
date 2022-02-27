package me.upp.parser;

import org.yuanheng.cookcc.CookCCToken;
import org.yuanheng.cookcc.TokenGroup;

@CookCCToken
public enum Token {
    @TokenGroup
    ID,
    @TokenGroup
    ADD, SUB, DIV, ASSIGN;
}
