package me.upp.parser.syntactic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.upp.parser.Worker;
import me.upp.parser.syntactic.pys.Firsts;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class SyntacticWorker implements Worker {

    @Override
    public void compute() {

    }

    public void printFirsts() {
        for (final Firsts first : Firsts.values()) {
            System.out.print(first + " -> " + Arrays.toString(first.getTerminals()));
            System.out.println();
        }
    }
}