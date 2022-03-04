package me.upp.parser.lexical;

import lombok.AllArgsConstructor;
import me.upp.parser.lexical.expressions.Expressions;
import me.upp.parser.lexical.tokens.TokenTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class Worker {

    private final String expression;

    public void compute() {
        for (final Pattern pattern : Expressions.PATTERNS) {
            final Matcher matcher = pattern.matcher(this.expression);
            while (matcher.find()) {
                final String group = matcher.group();
                System.out.println(group);
                final TokenTypes bySymbol = TokenTypes.getBySymbol(group);
                if (bySymbol != null) System.out.println(" | Symbol: " + bySymbol.name());
            }
        }
    }
}
