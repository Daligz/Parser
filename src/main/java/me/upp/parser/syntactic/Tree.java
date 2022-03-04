package me.upp.parser.syntactic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Tree {

    private final List<Enum<?>> nodes = new ArrayList<>();

    public void generate(final Enum<?> defEnum) {
        this.nodes.add(defEnum);
        if (defEnum instanceof final Grammar grammar) {
            if (grammar.isTerminal(grammar.getFirst())) {
                this.nodes.add(grammar.getFirst());
            } else {
                final Grammar toGrammar = Grammar.toGrammar(grammar.getFirst());
                if (toGrammar != null) this.generate(toGrammar);
            }
            if (grammar.isTerminal(grammar.getOperator())) {
                this.nodes.add(grammar.getOperator());
            } else {
                final Grammar toGrammar = Grammar.toGrammar(grammar.getOperator());
                if (toGrammar != null) this.generate(toGrammar);
            }
            if (grammar.isTerminal(grammar.getSecond())) {
                this.nodes.add(grammar.getSecond());
            } else {
                final Grammar toGrammar = Grammar.toGrammar(grammar.getSecond());
                if (toGrammar != null) this.generate(toGrammar);
            }
        }
    }
}
