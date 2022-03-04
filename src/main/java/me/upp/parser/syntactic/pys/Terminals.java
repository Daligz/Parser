package me.upp.parser.syntactic.pys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Terminals {
    $("$"), EQUAL("="), DIV("/"), SUM("+"),
    SUB("-"), NUM("num"), ID("id");

    private final String value;

    public static String getValuesToPrint(final Terminals... terminals) {
        final StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < terminals.length; i++) {
            stringBuilder.append(terminals[i].getValue());
            if ((i + 1) < terminals.length) stringBuilder.append(", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
