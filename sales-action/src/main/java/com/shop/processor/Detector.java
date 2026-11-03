package com.shop.processor;

import com.shop.constants.Delimiter;
import com.shop.service.DelimiterDetector;

import java.util.Arrays;
import java.util.List;

public class Detector implements DelimiterDetector {
    @Override
    public Delimiter detectDelimiter(List<String> lines) {
        return Arrays.stream(Delimiter.values())
                .filter(delimiter -> lines.stream()
                        .anyMatch(line -> line.contains(
                                String.valueOf(delimiter.getSymbol())
                        )))
                .findFirst()
                .orElseThrow();
    }
}
