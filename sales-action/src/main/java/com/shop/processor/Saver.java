package com.shop.processor;

import com.shop.service.FileSaver;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Saver implements FileSaver {

    @Override
    public void save(Path path, Map<String, BigDecimal> results) throws IOException {
        List<String> result = results.entrySet().stream()
                .map(entry -> entry.getKey() + " "
                        + entry.getValue().setScale(0, RoundingMode.HALF_UP))
                .collect(Collectors.toList());

        Files.write(path, result);
    }
}