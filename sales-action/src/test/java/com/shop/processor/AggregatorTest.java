package com.shop.processor;

import com.shop.entity.SaleResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AggregatorTest {

    Aggregator aggregator = new Aggregator();

    @Test
    void testDifferentCompaniesName() {
        SaleResult result1 = new SaleResult("Industrial1", BigDecimal.valueOf(1000));
        SaleResult result2 = new SaleResult("Industrial2", BigDecimal.valueOf(2000));
        SaleResult result3 = new SaleResult("Industrial3", BigDecimal.valueOf(3000));
        List<SaleResult> results = List.of(result1, result2, result3);

        Map<String, BigDecimal> aggregate = aggregator.aggregate(results);
        assertEquals(3, aggregate.size());
        assertEquals(0, result1.getPrice().compareTo(aggregate.get("Industrial1")));
        assertEquals(0, result2.getPrice().compareTo(aggregate.get("Industrial2")));
        assertEquals(0, result3.getPrice().compareTo(aggregate.get("Industrial3")));
    }
}