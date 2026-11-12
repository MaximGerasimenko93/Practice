package com.shop.source;

import com.shop.entity.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FileAdapterTest {

    @Mock
    FileConverter fileConverter;
    Delimiter pipe = Delimiter.PIPE;
    Delimiter hash = Delimiter.HASH;

    FileAdapter fileAdapter;

    @Test
    void testCorrectConvertation() {
        String text1 = "2021-02-09T10:48:34|Mosque|33120";
        String[] splitText1 = text1.split(Pattern.quote(String.valueOf(pipe.getSymbol())));
        String text2 = "2021-02-09T08:19:22|Recovery|11340";
        String[] splitText2 = text2.split(Pattern.quote(String.valueOf(pipe.getSymbol())));
        Order order1 = new Order(LocalDateTime.parse(splitText1[0]), splitText1[1], Integer.parseInt(splitText1[2]));
        Order order2 = new Order(LocalDateTime.parse(splitText2[0]), splitText2[1], Integer.parseInt(splitText2[2]));

        when(fileConverter.convert(text1, pipe)).thenReturn(order1);
        when(fileConverter.convert(text2, pipe)).thenReturn(order2);

        List<String> lines = List.of(text1, text2);
        List<Order> orders = fileAdapter.readLines(lines);

        assertEquals(List.of(order1, order2), orders);
        verify(fileConverter).convert(text1, pipe);
        verify(fileConverter).convert(text2, pipe);
    }

    @BeforeEach
    void setUp() {
        fileAdapter = new FileAdapter(fileConverter, pipe);
    }
}