package me.upp.parser.syntactic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.upp.parser.Worker;
import me.upp.parser.syntactic.pys.Firsts;
import me.upp.parser.syntactic.pys.Nexts;
import me.upp.parser.syntactic.pys.Terminals;

@Getter
@AllArgsConstructor
public class SyntacticWorker implements Worker {

    @Override
    public void compute() {

    }

    public void printFirsts() {
        System.out.println("PRIMEROS");
        for (final Firsts first : Firsts.values()) {
            System.out.print(first + " -> " + Terminals.getValuesToPrint(first.getTerminals()));
            System.out.println();
        }
    }

    public void printNexts() {
        System.out.println("SIGUIENTES");
        for (final Nexts next : Nexts.values()) {
            System.out.print(next + " -> " + Terminals.getValuesToPrint(next.getTerminals()));
            System.out.println();
        }
    }

    public void printGrammar() {
        System.out.println("GRAMATICA");
        for (final Grammar grammar : Grammar.values()) {
            System.out.print(grammar + " -> " + grammar.getValueToPrint());
            System.out.println();
        }
    }

    public void printTree() {
        System.out.println("ARBOL SINTACTICO");

    }
}