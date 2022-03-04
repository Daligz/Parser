package me.upp.parser.syntactic.pys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Terminals {
    $("$"), EQUAL("="), DIV("/"), SUM("+"),
    SUB("-"), NUM(""), ID("");
    private final String value;
}
