package com.aor.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    private BasicHero hero;
    private Monster monster;

    @BeforeEach
    void setUp() {
        hero = new BasicHero(new Position(10, 10), 10);
        monster = new Monster(10, 3);
    }

    @Test
    void attack() {
        hero.attack(monster);
        assertEquals(9, monster.getEnergy());
    }

    @Test
    void defend() {
        hero.defend(monster);
        assertEquals(7, hero.getEnergy());
    }

    @Test
    void decreaseEnergy() {
        hero.decreaseEnergy(2);
        assertEquals(8, hero.getEnergy());
    }
}