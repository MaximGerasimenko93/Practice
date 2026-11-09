package com.shop;

import com.shop.constants.Delimiter;
import com.shop.entity.Order;
import com.shop.entity.Sale;
import com.shop.entity.SaleResult;
import com.shop.processor.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    static void main(String[] args)throws IOException {
        FileConverter fileConverter = new FileConverter();
        FileAdapter fileAdapterForPipe = new FileAdapter(fileConverter, Delimiter.PIPE);

        Path pathForTxt = Path.of("src/main/resources/input/discount_day.txt");
        List<Order> ordersWithPipe = fileAdapterForPipe.readFile(pathForTxt);

        Sorter sorter = new Sorter();
        List<Order> sortWithPipe = sorter.sort(ordersWithPipe);

        Sale sale = new Sale(50, 5, 10);
        Calculator calculator = new Calculator();
        List<SaleResult> calculatedWithPipe = calculator.calculate(sortWithPipe, sale);

        Aggregator aggregator = new Aggregator();
        Map<String, BigDecimal> aggregatedPipe = aggregator.aggregate(calculatedWithPipe);

        Saver saver = new Saver();
        Path outputDirectory = Path.of("src/main/resources/output");
        Files.createDirectories(outputDirectory);
        Path outputFile = outputDirectory.resolve("result.txt");

        saver.save(outputFile, aggregatedPipe);
    }
}