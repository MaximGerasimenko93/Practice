package com.shop.processor;

import com.shop.entity.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    Sorter sorter = new Sorter();

    @Test
    void testCorrectSorting() {
        Order order1 = new Order(LocalDateTime.parse("2021-02-09T16:00:22"), "Industrial1", 10);
        Order order2 = new Order(LocalDateTime.parse("2021-02-11T16:00:22"), "Industrial2", 10);
        Order order3 = new Order(LocalDateTime.parse("2021-02-10T16:00:22"), "Industrial3", 10);
        List<Order> orders = List.of(order1, order2, order3);
        assertEquals(List.of(order1, order3, order2), sorter.sort(orders));
    }

    @Test
    void testAlreadySorting() {
        Order order1 = new Order(LocalDateTime.parse("2021-02-09T16:00:22"), "Industrial1", 10);
        Order order2 = new Order(LocalDateTime.parse("2021-02-11T16:00:22"), "Industrial2", 10);
        Order order3 = new Order(LocalDateTime.parse("2021-02-10T16:00:22"), "Industrial3", 10);
        List<Order> orders = List.of(order1, order3, order2);
        assertEquals(orders, sorter.sort(orders));
    }

    @Test
    void testOrdersWithEqualsTimeSorting() {
        Order order1 = new Order(LocalDateTime.parse("2021-02-09T16:00:22"), "Industrial1", 10);
        Order order2 = new Order(LocalDateTime.parse("2021-02-11T16:00:22"), "Industrial2", 10);
        Order order3 = new Order(LocalDateTime.parse("2021-02-09T16:00:22"), "Industrial3", 10);
        List<Order> orders = List.of(order1, order3, order2);
        assertEquals(orders, sorter.sort(orders));
    }
}