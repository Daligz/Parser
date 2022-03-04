package me.upp.parser;

import me.upp.parser.syntactic.Grammar;
import me.upp.parser.syntactic.SyntacticWorker;

public class Parser {

    public static void main(final String[] args) {
//        final LexicalWorker worker = new LexicalWorker("id+id-id=id+id-id/id");
//        worker.compute();
//        worker.print();
//        worker.check();
        final SyntacticWorker syntacticWorker = new SyntacticWorker();
        syntacticWorker.printFirsts();
        System.out.println();
        syntacticWorker.printNexts();
        System.out.println();
        syntacticWorker.printGrammar();
        System.out.println();
        syntacticWorker.printTree(Grammar.E);
        System.out.println();
    }
}