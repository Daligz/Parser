package me.upp.parser.lexical.expressions;

import java.util.regex.Pattern;

public class Expressions {
    public static final Pattern[] PATTERNS = {
            Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE),
            Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE),
            Pattern.compile("(=|-|\\/|\\+)", Pattern.CASE_INSENSITIVE)
    };
}
