package com.shop.service;

import com.shop.entity.Order;
import com.shop.entity.Sale;
import com.shop.entity.SaleResult;

import java.util.List;

public interface SaleCalculator {
    List<SaleResult> calculate(List<Order> orders, Sale sale);
}
