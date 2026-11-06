package com.shop.service;

import com.shop.entity.Order;

import java.util.List;

public interface OrderSorter {
    List<Order> sort(List<Order> orders);
}