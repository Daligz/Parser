package me.upp.parser;

import me.upp.parser.lexical.LexicalWorker;
import me.upp.parser.semantic.SemanticWorker;
import me.upp.parser.syntactic.Grammar;
import me.upp.parser.syntactic.SyntacticWorker;

import java.util.Scanner;

public class Parser {

    public static void main(final String[] args) {
        System.out.print("Expresion: ");
        final String expression = new Scanner(System.in)
                .nextLine()
                .replace(" ", "#");
        final LexicalWorker lexicalWorker = new LexicalWorker(expression);
        lexicalWorker.compute();
        lexicalWorker.print();
        if (!(lexicalWorker.check())) return;
        final SyntacticWorker syntacticWorker = new SyntacticWorker(expression, lexicalWorker);
        syntacticWorker.printFirsts();
        System.out.println();
        syntacticWorker.printNexts();
        System.out.println();
        syntacticWorker.printGrammar();
        System.out.println();
        syntacticWorker.printTree(Grammar.E);
        System.out.println();
        syntacticWorker.printTable();
        System.out.println();
        syntacticWorker.compute();
        System.out.println();
        final SemanticWorker semanticWorker = new SemanticWorker(expression, lexicalWorker);
        semanticWorker.compute();
    }
}