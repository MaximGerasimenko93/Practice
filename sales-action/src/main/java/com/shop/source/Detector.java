package com.shop.source;

import java.util.Arrays;
import java.util.List;

public class Detector implements DelimiterDetector {
    @Override
    public Delimiter detectDelimiter(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: список пуст");
        }
        List<Delimiter> delimiters = Arrays.stream(Delimiter.values())
                .filter(delimiter -> lines.stream()
                        .anyMatch(line -> line.contains(
                                String.valueOf(delimiter.getSymbol())
                        )))
                .toList();
        if (delimiters.size() != 1) {
            throw new DelimiterException("Некорректное количество разделителей");
        }
        return delimiters.getFirst();
    }
}