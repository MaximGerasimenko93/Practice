package com.shop.source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileFinder {
    public List<Path> findFiles(Path directory) throws IOException {
        try (Stream<Path> list = Files.list(directory)) {
            return list.filter(Files::isRegularFile).toList();
        }
    }
}