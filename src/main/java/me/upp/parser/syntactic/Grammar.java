package me.upp.parser.syntactic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.upp.parser.syntactic.pys.NonTerminals;
import me.upp.parser.syntactic.pys.Terminals;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Grammar {

    E(NonTerminals.A, Terminals.EQUAL, NonTerminals.B, null),
    A(NonTerminals.C, Terminals.SUB, NonTerminals.D, Grammar.E),
    B1(NonTerminals.B, Terminals.DIV, NonTerminals.D, Grammar.A),
    B2(NonTerminals.C, Terminals.SUB, NonTerminals.D, Grammar.B1),
    C(NonTerminals.D, Terminals.SUM, NonTerminals.D, Grammar.B2),
    D(Terminals.NUM, Terminals.OR, Terminals.ID, Grammar.C);

    private final Enum<?> first, operator, second;
    private final Grammar previous;

    public static List<Grammar> getFromOperator(final List<String> terminals) {
        final List<Grammar> computedGrammars = new ArrayList<>();
        for (final Grammar grammar : Grammar.values()) {
            for (final String strTerminal : terminals) {
                final Terminals terminal = Grammar.fromSymbolToTerminal(strTerminal);
                if (terminal == null) continue;
                if (grammar.getOperator() == terminal) computedGrammars.add(grammar);
            }
        }
        return computedGrammars;
    }

    public static Terminals fromSymbolToTerminal(final String symbol) {
        for (final Terminals terminal : Terminals.values()) if (terminal.getValue().equalsIgnoreCase(symbol)) return terminal;
        return null;
    }

    public static NonTerminals fromSymbolToNonTerminal(final String symbol) {
        for (final NonTerminals nonTerminal : NonTerminals.values()) if (nonTerminal.name().equalsIgnoreCase(symbol)) return nonTerminal;
        return null;
    }

    public String getValueToPrint() {
        return "%s %s %s".formatted(
                this.getPrintValue(this.first),
                this.getPrintValue(this.operator),
                this.getPrintValue(this.second)
        );
    }

    public static Grammar toGrammar(final Enum<?> defEnum) {
        try {
            if (defEnum.name().startsWith("B")) return (Math.random() > 0.5d) ? Grammar.B1 : Grammar.B2;
            return Grammar.valueOf(defEnum.name());
        } catch (final Exception ex) {
            return null;
        }
    }

    private String getPrintValue(final Enum<?> defEnum) {
        return (isTerminal(defEnum)) ? ((Terminals) defEnum).getValue() : defEnum.name();
    }

    public static boolean isTerminal(final Enum<?> defEnum) {
        return (defEnum instanceof Terminals);
    }
}