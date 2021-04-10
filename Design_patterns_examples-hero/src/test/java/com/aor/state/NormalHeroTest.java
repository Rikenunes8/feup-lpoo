package com.aor.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalHeroTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10));
    }

    @Test
    void move() {
        hero.moveUp();
        assertEquals(new Position(10, 9), hero.getPosition());
    }

    @Test
    void drinkPotion() {
        hero.drinkPotion();
        hero.moveUp();
        assertEquals(new Position(10, 8), hero.getPosition());
    }

    @Test
    void eatFood() {
        int initialEnergy = hero.getEnergy();
        hero.eatFood();
        assertEquals(initialEnergy + 10, hero.getEnergy());
    }

    @Test
    void gotoSleep() {
        while(hero.getEnergy() > 0)
            hero.timePasses();
        hero.moveUp();
        assertEquals(new Position(10, 10), hero.getPosition());
    }
}