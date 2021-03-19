package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisibleByFilterTest {

    @Test
    void accept() {
        DivisibleByFilter dbf = new DivisibleByFilter(10);

        Assertions.assertTrue(dbf.accept(20));
        Assertions.assertFalse(dbf.accept(9));
    }
}