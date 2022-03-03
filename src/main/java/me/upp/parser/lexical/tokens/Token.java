package me.upp.parser.lexical.tokens;

import lombok.Data;

@Data
public class Token {
    private final TokenTypes tokenType;
    private final int index;
    private final String value;
}
