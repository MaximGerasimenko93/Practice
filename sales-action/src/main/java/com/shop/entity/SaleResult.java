package com.shop.entity;

import java.math.BigDecimal;

public class SaleResult {
    private final String name;
    private final BigDecimal price;

    public SaleResult(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}