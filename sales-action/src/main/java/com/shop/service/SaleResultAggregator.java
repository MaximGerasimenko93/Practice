package com.shop.service;

import com.shop.entity.SaleResult;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SaleResultAggregator {
    Map<String, BigDecimal> aggregate(List<SaleResult> results);
}
