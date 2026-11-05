package com.shop.processor;

import com.shop.constants.Delimiter;
import com.shop.service.DelimiterChanger;

import java.util.List;

public class Changer implements DelimiterChanger {
    private final Delimiter delimiter;

    @Override
    public List<String> changeDelimiter(List<String> lines, char newDelimiter) {
        return lines.stream()
                .map(line -> line.replace(delimiter.getSymbol(), newDelimiter))
                .toList();
    }

    public Changer(Delimiter delimiter) {
        this.delimiter = delimiter;
    }
}