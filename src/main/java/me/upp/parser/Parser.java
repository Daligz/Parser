package me.upp.parser;

import me.upp.parser.lexical.LexicalWorker;
import me.upp.parser.syntactic.Grammar;
import me.upp.parser.syntactic.SyntacticWorker;

public class Parser {

    public static void main(final String[] args) {
        final String expression = "id+id-id=id+id-id/id";
        final LexicalWorker lexicalWorker = new LexicalWorker(expression);
        lexicalWorker.compute();
        lexicalWorker.print();
        lexicalWorker.check();
        final SyntacticWorker syntacticWorker = new SyntacticWorker(expression, lexicalWorker);
        syntacticWorker.printFirsts();
        System.out.println();
        syntacticWorker.printNexts();
        System.out.println();
        syntacticWorker.printGrammar();
        System.out.println();
        syntacticWorker.printTree(Grammar.E);
        System.out.println();
        syntacticWorker.compute();
    }
}