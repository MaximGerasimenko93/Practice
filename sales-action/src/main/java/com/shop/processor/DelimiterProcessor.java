package com.shop.processor;

import com.shop.service.DelimiterChanger;

import java.util.List;

public class DelimiterProcessor {
    private final DelimiterChanger changer;

    public List<String> change(List<String> lines) {
        return changer.changeDelimiter(lines);
    }

    public DelimiterProcessor(DelimiterChanger changer) {
        this.changer = changer;
    }
}
