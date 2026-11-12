package com.shop.source;

import com.shop.entity.Order;

import java.util.List;

public interface FileSource {
    List<Order> readLines(List<String> lines);
}
