package com.shop;

import com.shop.constants.Delimiter;
import com.shop.constants.FileName;
import com.shop.processor.DelimiterStrategy;
import com.shop.processor.Detector;
import com.shop.processor.TextReader;
import com.shop.service.DelimiterChanger;
import com.shop.service.DelimiterDetector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main(String[] args)throws IOException {

        Path path = Path.of(
                System.getProperty("user.dir"),
                "input"
        );

        List<Path> files;
        try (Stream<Path> stream = Files.list(path)) {
            files = stream
                    .filter(Files::isRegularFile)
                    .filter(file -> file.getFileName()
                            .toString()
                            .startsWith(FileName.DISCOUNT_DAY.getPrefix()))
                    .sorted()
                    .toList();
        }
        TextReader textReader = new TextReader();
        DelimiterDetector definer = new Detector();

        for (Path file : files) {
            List<String> strings = textReader.readFile(file);
            Delimiter delimiter = definer.detectDelimiter(strings);
            DelimiterChanger changer = new DelimiterStrategy(delimiter);
            List<String> processedLines = changer.changeDelimiter(strings);
            System.out.println();
            System.out.println("Имя файла: " + file.getFileName());
            System.out.println();
            processedLines.forEach(System.out::println);
        }
    }
}
