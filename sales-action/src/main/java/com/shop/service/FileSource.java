package com.shop.service;

import com.shop.entity.Order;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileSource {
    List<Order> readFile(Path path) throws IOException;
}
