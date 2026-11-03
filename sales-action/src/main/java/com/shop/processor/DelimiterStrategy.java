package com.shop.processor;

import com.shop.constants.Delimiter;
import com.shop.service.DelimiterChanger;

import java.util.List;

public class DelimiterStrategy implements DelimiterChanger {
    private final Delimiter delimiter;

    @Override
    public List<String> changeDelimiter(List<String> lines) {
        return lines.stream()
                .map(line -> line.replace(delimiter.getSymbol(), ' '))
                .toList();
    }

    public DelimiterStrategy(Delimiter delimiter) {
        this.delimiter = delimiter;
    }
}
