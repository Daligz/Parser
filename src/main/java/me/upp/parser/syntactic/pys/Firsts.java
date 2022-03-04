package me.upp.parser.syntactic.pys;

import lombok.Getter;

@Getter
public enum Firsts {
    E(Terminals.NUM, Terminals.ID),
    A(Terminals.NUM, Terminals.ID),
    B(Terminals.NUM, Terminals.ID),
    C(Terminals.NUM, Terminals.ID),
    D(Terminals.NUM, Terminals.ID);

    private final Terminals[] terminals;

    Firsts(final Terminals... terminals) {
        this.terminals = terminals;
    }
}
