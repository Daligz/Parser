package me.upp.parser;

import com.github.jhoenicke.javacup.Main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CupGenerator {

    private static final String PATH_GENERATED_FILES = "src/main/java/me/upp/parser/generated";
    private static URL URL_SYM, URL_SYNTAX;

    static {
        try {
            URL_SYM = Paths.get("sym.java").toUri().toURL();
            URL_SYNTAX = Paths.get("syntax.java").toUri().toURL();
        } catch (final MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
    }

    public static void main(final String[] args) throws Exception {
        final URL resource = Parser.class.getResource("/syntax.cup");
        if (resource == null) {
            System.out.println("Invalid file input.");
            return;
        }
        final File file = Paths.get(resource.toURI()).toFile();
        final String[] parameters = { "-parser", "syntax", file.getPath() };
        checkFiles(URL_SYM, URL_SYNTAX);
        // Cup main class
        Main.main(parameters);
        moveGeneratedFiles();
    }

    private static void moveGeneratedFiles() throws IOException, URISyntaxException {
        final File toLocation = new File(PATH_GENERATED_FILES);
        if (toLocation.mkdir()) System.out.println("Folder created from generated classes!");
        moveFile(URL_SYM, new File(toLocation, "sym.java").toURI().toURL());
        moveFile(URL_SYNTAX, new File(toLocation, "syntax.java").toURI().toURL());
        System.out.println("Files generated successfully!");
    }

    private static void moveFile(final URL from, final URL to) throws URISyntaxException, IOException {
        System.out.println("(Generated file) moving file...");
        Files.move(Paths.get(from.toURI()), Paths.get(to.toURI()), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void checkFiles(final URL... urls) throws URISyntaxException {
        for (final URL from : urls) {
            if (from == null) return;
            final File file = Paths.get(from.toURI()).toFile();
            if (!(file.exists())) return;
            final String name = file.getName();
            if (file.delete()) System.out.println("(Generated file) " + name + " deleted!");
        }
    }
}
