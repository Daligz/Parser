package me.upp.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParseStart;
import com.github.javaparser.ast.CompilationUnit;

import static com.github.javaparser.Providers.provider;

public class Test {

    public void compute(final JavaParser javaParser, final String expression) {
        final ParseResult<CompilationUnit> parse = javaParser.parse(ParseStart.COMPILATION_UNIT, provider(expression));
        if (!(parse.isSuccessful())) {
            System.out.println("chale");
            System.out.println(parse.getProblems().toString());
        } else {
            parse.ifSuccessful(System.out::println);
        }
    }
}
