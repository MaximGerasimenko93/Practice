package com.shop.processor;

import com.shop.constants.Delimiter;
import com.shop.entity.Order;
import com.shop.service.FileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileAdapter implements FileSource {

    private final FileConverter converter;
    private final Delimiter delimiter;

    @Override
    public List<Order> readFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Order> orders = new ArrayList<>();

        for (String line : lines) {
            orders.add(converter.convert(line, delimiter));
        }

        return orders;
    }

    public FileAdapter(FileConverter converter, Delimiter delimiter) {
        this.converter = converter;
        this.delimiter = delimiter;
    }
}