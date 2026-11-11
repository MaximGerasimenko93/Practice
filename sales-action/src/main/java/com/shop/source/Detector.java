package com.shop.source;

import java.util.Arrays;
import java.util.List;

public class Detector implements DelimiterDetector {
    @Override
    public Delimiter detectDelimiter(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: список пуст");
        }

        final int REQUIRED_ARRAY_SIZE = 1;
        List<Delimiter> delimiters = Arrays.stream(Delimiter.values())
                .filter(delimiter -> lines.stream()
                        .anyMatch(line -> line.contains(
                                String.valueOf(delimiter.getSymbol())
                        )))
                .toList();
        if (delimiters.size() != REQUIRED_ARRAY_SIZE) {
            throw new DelimiterException("Некорректное количество разделителей");
        }
        return delimiters.getFirst();
    }
}