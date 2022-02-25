package me.upp.parser;

import com.github.javaparser.JavaParser;

public class Parser {

    public static final String EXPRESSION = "id+id-id=id+id-id/id";

    public static void main(final String[] args) {
        new Test().compute(new JavaParser(), Parser.EXPRESSION);
    }
}
