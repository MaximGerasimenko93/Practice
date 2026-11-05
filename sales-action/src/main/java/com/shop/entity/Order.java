package com.shop.entity;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime id;
    private String name;
    private Integer amount;

    public Order(LocalDateTime id, String name, Integer amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public LocalDateTime getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }
}
