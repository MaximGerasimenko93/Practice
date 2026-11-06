package com.shop.service;

import com.shop.constants.Delimiter;

import java.util.List;

public interface DelimiterChanger {
    List<String> changeDelimiter(List<String> lines, char newDelimiter);
}