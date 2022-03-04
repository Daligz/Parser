package me.upp.parser.lexical.tokens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.upp.parser.lexical.expressions.Expressions;

@Getter
@AllArgsConstructor
public enum TokenTypes {
    IDENTIFIERS(0),
    NUMBERS(1),
    OPERATORS(2);

    private final int expressionId;

    public static TokenTypes getBySymbol(final String symbol) {
        if (Expressions.PATTERNS[IDENTIFIERS.getExpressionId()].matcher(symbol).find()) {
            return IDENTIFIERS;
        } else if (Expressions.PATTERNS[NUMBERS.getExpressionId()].matcher(symbol).find()) {
            return NUMBERS;
        } else if (Expressions.PATTERNS[OPERATORS.getExpressionId()].matcher(symbol).find()) {
            return OPERATORS;
        }
        return null;
    }
}