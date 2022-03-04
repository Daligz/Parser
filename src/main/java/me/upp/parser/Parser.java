package me.upp.parser;

import me.upp.parser.syntactic.SyntacticWorker;

public class Parser {

    public static void main(final String[] args) {
//        final LexicalWorker worker = new LexicalWorker("id+id-id=id+id-id/id");
//        worker.compute();
//        worker.print();
//        worker.check();
        final SyntacticWorker syntacticWorker = new SyntacticWorker();
        syntacticWorker.printFirsts();
    }
}