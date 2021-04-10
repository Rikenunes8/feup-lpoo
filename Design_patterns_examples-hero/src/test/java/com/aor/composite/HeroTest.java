package com.aor.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {

    @Test
    void decreaseEnergy() {
        Hero hero = new Hero(new Position(10, 10), 10);

        hero.decreaseEnergy(2);

        assertEquals(8, hero.getEnergy());
    }

}