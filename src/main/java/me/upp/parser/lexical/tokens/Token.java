package me.upp.parser.lexical.tokens;

import lombok.Data;

import java.util.regex.Pattern;

@Data
public class Token {
    private final TokenTypes tokenType;
    private final int index;
    private final String value;
    private final Pattern pattern;
}
