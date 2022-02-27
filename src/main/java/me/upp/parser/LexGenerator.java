package me.upp.parser;

import jflex.Main;
import jflex.exceptions.SilentExit;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class LexGenerator {

    private static final String PATH_LEXER = "src/main/resources/flex/lexerCup.flex";

    public static void main(final String[] args) throws SilentExit, IOException {
        final File toLocation = new File(CupGenerator.PATH_GENERATED_FILES);
        final Path path = Paths.get(PATH_LEXER);
        final URI lexerCupResource = path.toUri();
        Main.generate(new String[] { Paths.get(lexerCupResource).toFile().toString() });
        Files.move(new File("src/main/resources/flex/LexerCup.java").toPath(), new File(toLocation, "LexerCup.java").toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
