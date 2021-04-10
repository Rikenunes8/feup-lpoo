package com.aor.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PositionTest {
    @Test
    void samePosition() {
        Position p1 = new Position(10, 10);
        Position p2 = new Position(10, 10);

        assertEquals(p2, p1);
        assertEquals(p1, p2);
    }

    @Test
    void differentPosition() {
        Position p1 = new Position(10, 10);
        Position p2 = new Position(5, 5);

        assertNotEquals(p2, p1);
        assertNotEquals(p1, p2);
    }

    @Test
    void moveTo() {
        Position p1 = new Position(10, 10);
        Position p2 = new Position(5, 5);

        p2.moveTo(p1);

        assertEquals(p2, p1);
    }
}