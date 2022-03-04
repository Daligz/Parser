package me.upp.parser.syntactic;

import lombok.Getter;
import me.upp.parser.syntactic.pys.Terminals;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Tree {

    private final List<Enum<?>> nodes = new ArrayList<>();

    public void generate(final Enum<?> defEnum) {
        this.nodes.add(defEnum);
        if (defEnum instanceof final Grammar grammar) {
            if (Grammar.isTerminal(grammar.getFirst())) {
                if (grammar.getFirst() != Terminals.NUM
                        && grammar.getFirst() != Terminals.OR) this.nodes.add(grammar.getFirst());
            } else {
                this.toGrammarUpdate(grammar.getFirst());
            }
            if (Grammar.isTerminal(grammar.getOperator())) {
                if (grammar.getOperator() != Terminals.NUM
                        && grammar.getOperator() != Terminals.OR) this.nodes.add(grammar.getOperator());
            } else {
                this.toGrammarUpdate(grammar.getOperator());
            }
            if (Grammar.isTerminal(grammar.getSecond())) {
                if (grammar.getSecond() != Terminals.NUM
                        && grammar.getSecond() != Terminals.OR) this.nodes.add(grammar.getSecond());
            } else {
                this.toGrammarUpdate(grammar.getSecond());
            }
        }
    }

    private void regenerate(final Grammar grammar) {
        this.nodes.clear();
        this.generate(grammar);
    }

    private void toGrammarUpdate(final Enum<?> defEnum) {
        final Grammar toGrammar = Grammar.toGrammar(defEnum);
        if (toGrammar != null) this.generate(toGrammar);
    }
}
