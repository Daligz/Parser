package me.upp.parser.syntactic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.upp.parser.syntactic.pys.NonTerminals;
import me.upp.parser.syntactic.pys.Terminals;

@Getter
@AllArgsConstructor
public enum Grammar {

    E(NonTerminals.A, Terminals.EQUAL, NonTerminals.B),
    A(NonTerminals.C, Terminals.SUB, NonTerminals.D),
    B1(NonTerminals.B, Terminals.DIV, NonTerminals.D),
    B2(NonTerminals.C, Terminals.SUB, NonTerminals.D),
    C(NonTerminals.D, Terminals.SUM, NonTerminals.D),
    D(Terminals.NUM, Terminals.OR, Terminals.ID);

    private final Enum<?> first, operator, second;

    public String getValueToPrint() {
        return "%s %s %s".formatted(
                this.getPrintValue(this.first),
                this.getPrintValue(this.operator),
                this.getPrintValue(this.second)
        );
    }

    public static Grammar toGrammar(final Enum<?> defEnum) {
        try {
            return Grammar.valueOf(defEnum.name());
        } catch (final Exception ex) {
            return null;
        }
    }

    private String getPrintValue(final Enum<?> defEnum) {
        return (this.isTerminal(defEnum)) ? ((Terminals) defEnum).getValue() : defEnum.name();
    }

    public boolean isTerminal(final Enum<?> defEnum) {
        return (defEnum instanceof Terminals);
    }
}