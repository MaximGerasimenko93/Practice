package com.shop.processor;

import com.shop.constants.Delimiter;
import com.shop.entity.Order;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class FileConverter {

    public Order convert(String text, Delimiter delimiter) {

        String[] fields = text.split(Pattern.quote(String.valueOf(delimiter.getSymbol())), -1);

        if (fields.length != 3) {
            throw new ArrayIndexOutOfBoundsException("Не все данные внесены");
        }

        LocalDateTime time = LocalDateTime.parse(fields[0]);
        String name = fields[1];
        int amount = Integer.parseInt(fields[2]);

        return new Order(time, name, amount);
    }
}
