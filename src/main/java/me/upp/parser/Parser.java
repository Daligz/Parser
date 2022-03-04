package me.upp.parser;

import me.upp.parser.lexical.LexicalWorker;

public class Parser {

    public static void main(final String[] args) {
        final LexicalWorker worker = new LexicalWorker("* ** ( ) () )(& ^ %^  123123 123 2 id+id-id=id+id-id/id");
        worker.compute();
        worker.print();
        worker.check();
    }
}