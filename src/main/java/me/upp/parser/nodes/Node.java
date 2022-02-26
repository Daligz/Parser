package me.upp.parser.nodes;

import me.upp.parser.Token;

public class Node {

    private final Token token;

    public Node(final Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
