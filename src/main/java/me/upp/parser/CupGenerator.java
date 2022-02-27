package me.upp.parser;

import com.github.jhoenicke.javacup.Main;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class CupGenerator {

    public static void main(final String[] args) throws Exception {
        final URL resource = Parser.class.getResource("/syntax.cup");
        if (resource == null) {
            System.out.println("Invalid file input.");
            return;
        }
        final File file = Paths.get(resource.toURI()).toFile();
        final String[] parameters = { "-parser", "syntax", file.getPath() };
        // Cup main class
        Main.main(parameters);
    }
}
