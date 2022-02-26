package me.upp.parser;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(final String[] args) throws IOException {
        final Test test = new Test();
        final InputStream resourceAsStream = Main.class.getResourceAsStream("/test.input");
        test.setInput(resourceAsStream);
        if (test.yyParse() > 0) {
            System.out.println("Input error");
        } else {
            System.out.println("Sin errores!");
        }
    }
}
