package me.upp.parser;

import me.upp.parser.lexical.LexicalWorker;
import me.upp.parser.syntactic.Grammar;
import me.upp.parser.syntactic.SyntacticWorker;

public class Parser {

    public static void main(final String[] args) {
        final String expression = "id+id-id=id+id-id/id";
        final LexicalWorker worker = new LexicalWorker(expression);
        worker.compute();
        worker.print();
        worker.check();
        final SyntacticWorker syntacticWorker = new SyntacticWorker();
        syntacticWorker.printFirsts();
        System.out.println();
        syntacticWorker.printNexts();
        System.out.println();
        syntacticWorker.printGrammar();
        System.out.println();
        syntacticWorker.printTree(Grammar.E);
        System.out.println();
        Enum<?> terminal = Grammar.fromSymbolToTerminal("id");
        System.out.println("Terminal: " + terminal);
        terminal = Grammar.fromSymbolToTerminal("+");
        System.out.println("Terminal: " + terminal);
        terminal = Grammar.fromSymbolToTerminal("num");
        System.out.println("Terminal: " + terminal);
        terminal = Grammar.fromSymbolToNonTerminal("e");
        System.out.println("NonTerminal: " + terminal);
        terminal = Grammar.fromSymbolToNonTerminal("c");
        System.out.println("NonTerminal: " + terminal);
        terminal = Grammar.fromSymbolToNonTerminal("d");
        System.out.println("NonTerminal: " + terminal);
        terminal = Grammar.fromSymbolToTerminal("=");
        System.out.println("Terminal: " + terminal);
    }
}