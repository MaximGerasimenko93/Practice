package com.shop.source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFileReader {
    public List<String> readFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
