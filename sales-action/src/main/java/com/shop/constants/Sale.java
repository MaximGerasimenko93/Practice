package com.shop.constants;

public enum Sale {
    START(50),
    STEP(5);

    private final int value;

    Sale(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
