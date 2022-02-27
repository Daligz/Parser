package me.upp.parser.nodes;

import me.upp.parser.Token;

public class ExpressionNode extends Node {

    private final Node stmt1, stmt2;

    public ExpressionNode(final Node stmt1, final Node stmt2) {
        super(Token.ADD);
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }
}
