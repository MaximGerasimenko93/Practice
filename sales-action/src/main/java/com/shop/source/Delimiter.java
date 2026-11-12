package com.shop.source;

public enum Delimiter {
    PIPE('|'),
    HASH('#'),
    SEMICOLON(';'),
    COMMA(',');

    private final char symbol;

    Delimiter(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}