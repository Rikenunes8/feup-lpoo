package com.aor.state;

import com.aor.state.states.SleepingState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SleepingHeroTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10));
        hero.setState(new SleepingState(hero));
    }

    @Test
    void cantMove() {
        hero.moveUp();
        assertEquals(new Position(10, 10), hero.getPosition());
    }

    @Test
    void cantDrinkPotion() {
        hero.drinkPotion();
        hero.moveUp();
        assertEquals(new Position(10, 10), hero.getPosition());
    }

    @Test
    void cantEatFood() {
        hero.eatFood();
        assertEquals(10, hero.getEnergy());
    }

    @Test
    void wakeUp() {
        while(hero.getEnergy() <= 10)
            hero.timePasses();
        hero.moveUp();
        System.out.println(hero.getPosition().getY());
        assertEquals(new Position(10, 9), hero.getPosition());
    }
}