package me.upp.parser;

import me.upp.parser.lexical.Worker;

public class Parser {

    public static void main(final String[] args) {
        final Worker worker = new Worker("* ** ( ) () )(& ^ %^  123123 123 2 id+id-id=id+id-id/id");
        worker.compute();
        worker.print();
        worker.check();
    }
}
