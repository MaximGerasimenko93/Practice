package com.shop.source;

import com.shop.entity.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class FileConverterTest {

    FileConverter fileConverter = new FileConverter();

    @Test
    void testStringWithPipe() {
        Delimiter pipe = Delimiter.PIPE;
        String text = "2021-02-09T16:00:22|Industrial|8800";
        LocalDateTime time = LocalDateTime.parse("2021-02-09T16:00:22");
        String name = "Industrial";
        int amount = 8800;

        Order order = fileConverter.convert(text, pipe);

        assertEquals(time, order.getTime());
        assertEquals(name, order.getName());
        assertEquals(amount, order.getAmount());
    }

    @Test
    void testStringWithHash() {
        Delimiter hash = Delimiter.HASH;
        String text = "2021-02-09T16:00:22#Industrial#8800";
        LocalDateTime time = LocalDateTime.parse("2021-02-09T16:00:22");
        String name = "Industrial";
        int amount = 8800;

        Order order = fileConverter.convert(text, hash);

        assertEquals(time, order.getTime());
        assertEquals(name, order.getName());
        assertEquals(amount, order.getAmount());
    }

    @Test
    void testWrongDateFormat() {
        Delimiter hash = Delimiter.HASH;
        String text = "11.11.2026#Industrial#8800";
        assertThrows(DateTimeParseException.class, () -> {
            fileConverter.convert(text, hash);
        });
    }

    @Test
    void testWrongDAmount() {
        Delimiter hash = Delimiter.HASH;
        String text = "2021-02-09T16:00:22#Industrial#13.85";
        assertThrows(NumberFormatException.class, () -> {
            fileConverter.convert(text, hash);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2021-02-09T16:00:22|Industrial",
            "2021-02-09T16:00:22|Industrial|8800|abc"})
    void testWrongArraySize(String text) {
        Delimiter pipe = Delimiter.PIPE;

        assertThrows(IllegalArgumentException.class, () -> {
            fileConverter.convert(text, pipe);
        });
    }
}