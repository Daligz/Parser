package me.upp.parser.semantic;

import lombok.AllArgsConstructor;
import me.upp.parser.Worker;
import me.upp.parser.lexical.tokens.Token;
import me.upp.parser.lexical.tokens.TokenTypes;
import me.upp.parser.semantic.expressions.Expressions;
import me.upp.parser.syntactic.SyntacticWorker;

import java.util.List;
import java.util.regex.Matcher;

@AllArgsConstructor
public class SemanticWorker implements Worker {

    private final String expression;
    private final Worker syntacticWorker;

    @Override
    public void compute() {
        final List<Token> tokens = ((SyntacticWorker) this.syntacticWorker)
                .getLexicalWorker()
                .getTokens()
                .get(TokenTypes.OPERATORS);
        final Matcher matcher = Expressions.PATTERN.matcher(this.expression);
        int matches = 0;
        while (matcher.find()) matches++;
        System.out.println("Matches: " + matches);
        System.out.println("Matches (Lexical): " + tokens.size());
    }
}
