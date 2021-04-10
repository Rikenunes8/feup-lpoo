package com.aor.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElementTest {
    private Hero hero; // Element is abstract, let's test with an hero.

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10), 10);
    }

    @Test
    void moveUp() {
        hero.moveUp();
        assertEquals(new Position(10, 9), hero.getPosition());
    }

    @Test
    void moveRight() {
        hero.moveRight();
        assertEquals(new Position(11, 10), hero.getPosition());
    }

    @Test
    void moveDown() {
        hero.moveDown();
        assertEquals(new Position(10, 11), hero.getPosition());
    }

    @Test
    void moveLeft() {
        hero.moveLeft();
        assertEquals(new Position(9, 10), hero.getPosition());
    }
}