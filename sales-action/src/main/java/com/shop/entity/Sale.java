package com.shop.entity;

public class Sale {
    private final int startDiscount;
    private final int step;
    private final int cost;

    public Sale(int startDiscount, int step, int cost) {
        this.startDiscount = startDiscount;
        this.step = step;
        this.cost = cost;
    }

    public int getStartDiscount() {
        return startDiscount;
    }

    public int getStep() {
        return step;
    }

    public int getCost() {
        return cost;
    }
}
