package com.shop;

import com.shop.source.Delimiter;
import com.shop.entity.Order;
import com.shop.entity.Sale;
import com.shop.entity.SaleResult;
import com.shop.processor.*;
import com.shop.source.*;
import com.shop.storage.Saver;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    static void main(String[] args)throws IOException {
        FileFinder fileFinder = new FileFinder();
        ConsoleReader consoleReader = new ConsoleReader();
        TextFileReader textFileReader = new TextFileReader();
        Detector detector = new Detector();
        FileConverter fileConverter = new FileConverter();
        Sorter sorter = new Sorter();
        Sale sale = new Sale(50, 5, 100);
        Calculator calculator = new Calculator();
        Aggregator aggregator = new Aggregator();
        Saver saver = new Saver();

        Path path = Path.of("src/main/resources/input");
        List<Path> files = fileFinder.findFiles(path);
        Path input = consoleReader.selectFile(files);

        List<String> lines = textFileReader.readFile(input);
        Delimiter delimiter = detector.detectDelimiter(lines);
        FileAdapter fileAdapter = new FileAdapter(fileConverter, delimiter);
        List<Order> orders = fileAdapter.readLines(lines);
        List<Order> sortedOrders = sorter.sort(orders);
        List<SaleResult> calculatedOrders = calculator.calculate(sortedOrders, sale);
        Map<String, BigDecimal> aggregatedOrders = aggregator.aggregate(calculatedOrders);

        Path outputDirectory = Path.of("src/main/resources/output");
        Files.createDirectories(outputDirectory);
        Path outputFile = outputDirectory.resolve("result.txt");

        saver.save(outputFile, aggregatedOrders);
    }
}