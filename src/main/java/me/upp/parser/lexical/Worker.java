package me.upp.parser.lexical;

import lombok.AllArgsConstructor;
import me.upp.parser.lexical.expressions.Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class Worker {

    private final String expression;

    public void compute() {
        for (final Pattern pattern : Expressions.PATTERNS) {
            final Matcher matcher = pattern.matcher(this.expression);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }

    public void print() {

    }

    public void check() {

    }
}
