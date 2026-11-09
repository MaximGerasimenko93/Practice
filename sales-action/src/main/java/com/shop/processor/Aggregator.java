package com.shop.processor;

import com.shop.entity.SaleResult;
import com.shop.service.SaleResultAggregator;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Aggregator implements SaleResultAggregator {

    @Override
    public Map<String, BigDecimal> aggregate(List<SaleResult> results) {
        Map<String, BigDecimal> saleAggregator = new LinkedHashMap<>();
        for (SaleResult result : results) {
            saleAggregator.merge(result.getName(), result.getPrice(),
                    (oldValue, newValue) -> oldValue.add(newValue));
        }
        return saleAggregator;
    }
}
