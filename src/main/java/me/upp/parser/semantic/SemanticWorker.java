package me.upp.parser.semantic;

import lombok.AllArgsConstructor;
import me.upp.parser.Worker;
import me.upp.parser.lexical.LexicalWorker;
import me.upp.parser.lexical.tokens.Token;
import me.upp.parser.lexical.tokens.TokenTypes;
import me.upp.parser.semantic.expressions.Expressions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class SemanticWorker implements Worker {

    private final String expression;
    private final Worker lexicalWorker;

    @Override
    public void compute() {
        final List<Token> tokens = ((LexicalWorker) this.lexicalWorker)
                .getTokens()
                .get(TokenTypes.OPERATORS);
        int matches = 0;
        for (final Pattern pattern : Expressions.PATTERNS) {
            final Matcher matcher = pattern.matcher(this.expression);
            while (matcher.find()) matches++;
        }
        if (matches == tokens.size()) {
            System.out.println("Successful semantic expression");
        } else {
            System.out.println("Wrong semantic expression");
        }
    }
}
