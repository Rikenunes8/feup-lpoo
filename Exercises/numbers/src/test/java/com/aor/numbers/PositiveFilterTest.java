package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveFilterTest {

    @Test
    void accept() {
        PositiveFilter pf = new PositiveFilter();

        Assertions.assertTrue(pf.accept(1));
        Assertions.assertFalse(pf.accept(0));
        Assertions.assertFalse(pf.accept(-1));
    }
}