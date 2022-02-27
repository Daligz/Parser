package me.upp.parser;

import com.github.jhoenicke.javacup.runtime.Symbol;
import me.upp.parser.generated.LexerCup;
import me.upp.parser.generated.Syntax;

import java.io.StringReader;

public class Parser {

    public static void main(final String[] args) {
        final Syntax syntax = new Syntax(new LexerCup(new StringReader("id + id - id = id + id - id / id")));
        try {
            syntax.parse();
            System.out.println("Successful entry!");
        } catch (final Exception exception) {
            exception.printStackTrace();
            final Symbol symbol = syntax.getSymbol();
            System.out.println("Line: " + (symbol.right + 1));
            System.out.println("Column: " + (symbol.left + 1));
            System.out.println("Value: " + symbol.value);
        }
    }
}
