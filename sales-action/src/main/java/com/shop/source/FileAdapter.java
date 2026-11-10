package com.shop.source;

import com.shop.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class FileAdapter implements FileSource {

    private final FileConverter converter;
    private final Delimiter delimiter;

    @Override
    public List<Order> readLines(List<String> lines) {
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