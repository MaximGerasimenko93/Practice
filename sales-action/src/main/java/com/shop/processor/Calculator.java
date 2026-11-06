package com.shop.processor;

import com.shop.entity.Order;
import com.shop.entity.Sale;
import com.shop.entity.SaleResult;
import com.shop.service.SaleCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TODO: Доделать реализацию просчета скидки

public class Calculator implements SaleCalculator {
    @Override
    public List<SaleResult> calculate(List<Order> orders, Sale sale) {
        List<SaleResult> saleResult = new ArrayList<>();
        int discount = sale.getStartDiscount();
        for (Order order : orders) {
            BigDecimal amount = BigDecimal.valueOf(order.getAmount());
            BigDecimal cost = BigDecimal.valueOf(sale.getCost());
            BigDecimal discountCoefficient = BigDecimal.valueOf(discount).divide(BigDecimal.valueOf(100));
            BigDecimal price = amount
                    .multiply(cost)
                    .multiply(BigDecimal.ONE.subtract(discountCoefficient));
        }
        return null;
    }
}
