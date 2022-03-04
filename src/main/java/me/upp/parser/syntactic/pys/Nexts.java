package me.upp.parser.syntactic.pys;

import lombok.Getter;

@Getter
public enum Nexts {
    E(Terminals.$),
    A(Terminals.EQUAL, Terminals.$),
    B(Terminals.EQUAL, Terminals.DIV, Terminals.$),
    C(Terminals.EQUAL, Terminals.$),
    D(Terminals.EQUAL, Terminals.SUB, Terminals.DIV, Terminals.NUM, Terminals.ID, Terminals.$);

    private final Terminals[] terminals;

    Nexts(final Terminals... terminals) {
        this.terminals = terminals;
    }
}
