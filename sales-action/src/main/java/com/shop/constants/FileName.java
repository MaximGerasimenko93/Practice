package com.shop.constants;

public enum FileName {
    DISCOUNT_DAY("discount_day");

    private final String prefix;

    FileName(String name) {
        this.prefix = name;
    }

    public String getPrefix() {
        return prefix;
    }
}
