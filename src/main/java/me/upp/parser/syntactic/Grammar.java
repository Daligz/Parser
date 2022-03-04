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
}
