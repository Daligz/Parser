package me.upp.parser;

import com.github.jhoenicke.javacup.runtime.Symbol;
import me.upp.parser.generated.Syntax;

public class Parser {

    public static void main(final String[] args) {
        final Syntax syntax = new Syntax();
        try {
            syntax.parse();
        } catch (final Exception exception) {
            exception.printStackTrace();
            final Symbol symbol = syntax.getSymbol();
            System.out.println("Line: " + (symbol.right + 1));
            System.out.println("Column: " + (symbol.left + 1));
            System.out.println("Value: " + symbol.value);
        }
    }
}
