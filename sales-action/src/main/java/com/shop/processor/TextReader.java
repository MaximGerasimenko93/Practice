package com.shop.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextReader {
    public List<String> readFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
