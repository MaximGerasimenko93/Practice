package com.shop.processor;

import com.shop.entity.Order;
import com.shop.service.OrderSorter;

import java.util.Comparator;
import java.util.List;

public class Sorter implements OrderSorter {

    @Override
    public List<Order> sort(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getTime))
                .toList();
    }
}