package me.upp.parser.lexical;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.upp.parser.Worker;
import me.upp.parser.lexical.expressions.Expressions;
import me.upp.parser.lexical.tokens.Token;
import me.upp.parser.lexical.tokens.TokenTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public class LexicalWorker implements Worker {

    private String expression;
    private final Map<TokenTypes, List<Token>> tokens = new HashMap<>() {{
        put(TokenTypes.IDENTIFIERS, new ArrayList<>());
        put(TokenTypes.NUMBERS, new ArrayList<>());
        put(TokenTypes.OPERATORS, new ArrayList<>());
    }};

    public void compute() {
        for (final Pattern pattern : Expressions.PATTERNS) {
            final Matcher matcher = pattern.matcher(this.expression);
            while (matcher.find()) {
                final String group = matcher.group();
                final TokenTypes tokenType = TokenTypes.getBySymbol(group);
                final List<Token> tokens = this.tokens.get(tokenType);
                tokens.add(new Token(tokenType, tokens.size(), group));
            }
        }
    }

    public void print() {
        this.tokens.forEach((tokenTypes, tokens) -> {
            System.out.println(tokenTypes.name());
            System.out.println("-------------------------");
            tokens.forEach(System.out::println);
            System.out.println("-------------------------");
            System.out.println("");
        });
    }

    public boolean check() {
        this.tokens.forEach((tokenTypes, tokens) -> tokens.forEach(token -> this.expression = expression.replace(token.getValue(), "")));
        this.expression = this.expression.trim();
        if (!(this.expression.isBlank()) || !(this.expression.isEmpty())) {
            System.out.println("ERRORS");
            System.out.println("-------------------------");
            for (final String symbol : this.expression.split(" ")) System.out.println(symbol);
            System.out.println("-------------------------");
            return false;
        }
        return true;
    }
}
