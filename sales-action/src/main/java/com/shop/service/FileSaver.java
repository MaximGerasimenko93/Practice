package com.shop.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Map;

public interface FileSaver {
    void save(Path path, Map<String, BigDecimal> results) throws IOException;
}
