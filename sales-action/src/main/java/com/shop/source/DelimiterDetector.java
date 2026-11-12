package com.shop.source;

import java.util.List;

public interface DelimiterDetector {
    Delimiter detectDelimiter(List<String> lines);
}