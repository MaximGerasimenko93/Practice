package com.shop.processor;

import com.shop.entity.Order;
import com.shop.entity.Sale;
import com.shop.entity.SaleResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testCorrectResult() {
        List<Order> orders = List.of(new Order(LocalDateTime.parse("2021-02-09T16:00:22"), "Industrial", 10));
        Sale sale = new Sale(50, 5, 100);
        List<SaleResult> results = calculator.calculate(orders, sale);
        SaleResult result = results.getFirst();
        String name = result.getName();
        BigDecimal price = result.getPrice();
        assertEquals("Industrial", name);
        assertEquals(0, price.compareTo(BigDecimal.valueOf(500)));
    }

    @Test
    void testCorrectStepIncrement() {
        Sale sale = new Sale(50, 5, 100);
        Order order1 = new Order(LocalDateTime.parse("2021-02-09T16:00:22"), "Industrial1", 10);
        Order order2 = new Order(LocalDateTime.parse("2021-02-10T16:00:22"), "Industrial2", 10);
        Order order3 = new Order(LocalDateTime.parse("2021-02-11T16:00:22"), "Industrial3", 10);

        List<Order> orders = List.of(order1, order2, order3);
        List<SaleResult> results = calculator.calculate(orders, sale);
        SaleResult firstOrder = results.getFirst();
        SaleResult secondOrder = results.get(1);
        SaleResult thirdOrder = results.get(2);

        BigDecimal price1 = firstOrder.getPrice();
        BigDecimal price2 = secondOrder.getPrice();
        BigDecimal price3 = thirdOrder.getPrice();

        assertEquals(0, price1.compareTo(BigDecimal.valueOf(500)));
        assertEquals(0, price2.compareTo(BigDecimal.valueOf(550)));
        assertEquals(0, price3.compareTo(BigDecimal.valueOf(600)));
    }
}

//    @ParameterizedTest
//    @CsvSource({"2021-02-09T16:00:22, Industrial, 10",
//                "2021-02-10T16:00:22, Industrial, 10",
//                "2021-02-11T16:00:22, Industrial, 10",
//                "2021-02-12T16:00:22, Industrial, 10"})
//    void testZeroDiscount(){
//        //TODO: подумать какие параметры передать в аннотацию и доделать тест на случай, когда скидка опускается до 0.
//}