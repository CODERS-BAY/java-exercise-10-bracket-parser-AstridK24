package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Parser {

    private final Deque<Character> elementStack;

    public Parser() {
        elementStack = new ArrayDeque<>();
    }

    public void parseFile(final String filename) throws ParsingException {
        File file = new File(Main.class.getClassLoader().getResource(filename).getFile());
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNext()) {
            String line = scan.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '{') {
                    elementStack.push(c);
                } else if (c == '}') {
                    try {
                        elementStack.pop();
                    } catch (NoSuchElementException e) {
                        ParsingException p = new ParsingException("Error parsing the file. { expected");
                        throw p;
                    }
                }
            }
        }
        scan.close();
        if (!elementStack.isEmpty()) {
            ParsingException p = new ParsingException("Error parsing the file. } expected");
            throw p;
        }
    }

    public Deque<Character> getElementStack() {
        return elementStack;
    }
}


