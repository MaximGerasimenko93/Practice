package com.shop.service;

import com.shop.constants.Delimiter;

import java.util.List;

public interface DelimiterDetector {
    Delimiter detectDelimiter(List<String> lines);
}
