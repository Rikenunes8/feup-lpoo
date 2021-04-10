package com.aor.state;

import com.aor.state.states.PumpedState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PumpedHeroTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10));
        hero.setState(new PumpedState(hero));
    }

    @Test
    void move() {
        hero.moveUp();
        assertEquals(new Position(10, 8), hero.getPosition());
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
        assertEquals(initialEnergy + 20, hero.getEnergy());
    }

    @Test
    void timePasses() {
        while(hero.getEnergy() > 0)
            hero.timePasses();
        hero.moveUp();
        assertEquals(new Position(10, 10), hero.getPosition());
    }
}