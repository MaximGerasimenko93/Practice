package com.shop.entity;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime time;
    private String name;
    private int amount;

    public Order(LocalDateTime time, String name, int amount) {
        this.time = time;
        this.name = name;
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}