package application;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.stream.Stream;

public class Parser {

    private final Deque<Character> elementStack;

    public Parser() {
        elementStack = new ArrayDeque<>();
    }

    public void parseFile(final String filename) throws ParsingException {
    }

    public Deque<Character> getElementStack() {
        return elementStack;
    }
}


