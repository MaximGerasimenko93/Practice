package com.shop.source;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DetectorTest {

    private final Detector detector = new Detector();

    @Test
    void testReturningPipeDelimiter() {
        List<String> lines = List.of("2021-02-09T16:00:22|Industrial|8800","2021-02-09T08:42:59|Power Engineer|17480");
        Delimiter delimiter = detector.detectDelimiter(lines);
        assertEquals('|', delimiter.getSymbol());
    }

    @Test
    void testReturningHashDelimiter() {
        List<String> lines = List.of("2021-02-09T16:00:22#Industrial#8800","2021-02-09T08:42:59#Power Engineer#17480");
        Delimiter delimiter = detector.detectDelimiter(lines);
        assertEquals('#', delimiter.getSymbol());
    }

    @Test
    void testEmptyList() {
        List<String> lines = List.of();
        assertThrows(IllegalArgumentException.class, () -> {
            detector.detectDelimiter(lines);
        });
    }

    @Test
    void testNullList() {
        List<String> lines = null;
        assertThrows(IllegalArgumentException.class, () -> {
            detector.detectDelimiter(lines);
        });
    }

    @Test
    void testAnotherDelimiter() {
        List<String> lines = List.of("2021-02-09T16:00:22•Industrial•8800","2021-02-09T08:42:59•Power Engineer•17480");
        assertThrows(DelimiterException.class, () -> {
            detector.detectDelimiter(lines);
        });
    }

    @Test
    void testNotOneDelimiter() {
        List<String> lines = List.of("2021-02-09T16:00:22|Industrial|8800", "2021-02-09T16:00:22#Industrial#8800");
        assertThrows(DelimiterException.class, () -> {
            detector.detectDelimiter(lines);
        });
    }
}