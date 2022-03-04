package me.upp.parser.syntactic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.upp.parser.Worker;
import me.upp.parser.lexical.LexicalWorker;
import me.upp.parser.syntactic.pys.Firsts;
import me.upp.parser.syntactic.pys.Nexts;
import me.upp.parser.syntactic.pys.Terminals;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@AllArgsConstructor
public class SyntacticWorker implements Worker {

    private final String expression;
    private final LexicalWorker lexicalWorker;

    @Override
    public void compute() {
        AtomicReference<String> computedExpression = new AtomicReference<>(this.expression);
        this.lexicalWorker.getTokens().forEach((tokenTypes, tokens) -> tokens.forEach(token -> {
            computedExpression.updateAndGet(value -> value.replaceFirst(token.getPattern().toString(), ""));
            System.out.println(computedExpression.get() + " | " + token.getValue());
        }));
        computedExpression.updateAndGet(String::trim);
        if (computedExpression.get().isEmpty() || computedExpression.get().isBlank()) {
            System.out.println("Successful expression");
        } else {
            System.out.println("Error: " + computedExpression.get());
        }
    }

    public void printFirsts() {
        System.out.println("PRIMEROS");
        for (final Firsts first : Firsts.values()) {
            System.out.print(first + " -> " + Terminals.getValuesToPrint(first.getTerminals()));
            System.out.println();
        }
    }

    public void printNexts() {
        System.out.println("SIGUIENTES");
        for (final Nexts next : Nexts.values()) {
            System.out.print(next + " -> " + Terminals.getValuesToPrint(next.getTerminals()));
            System.out.println();
        }
    }

    public void printGrammar() {
        System.out.println("GRAMATICA");
        for (final Grammar grammar : Grammar.values()) {
            System.out.print(grammar + " -> " + grammar.getValueToPrint());
            System.out.println();
        }
    }

    public void printTree(final Grammar firstGrammar) {
        System.out.println("ARBOL SINTACTICO");
        final Tree tree = new Tree();
        tree.generate(firstGrammar);
        tree.getNodes().forEach(anEnum -> System.out.print(anEnum + ", "));
        System.out.println();
    }
}