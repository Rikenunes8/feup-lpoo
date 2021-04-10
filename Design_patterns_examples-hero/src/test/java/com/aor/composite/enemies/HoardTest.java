package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HoardTest {
    private Hoard hoard;

    @BeforeEach
    void setUp() {
        Guard guard = new Guard(new Position(5, 5));
        Spider spider = new Spider(new Position(3, 3));
        Wizard wizard = new Wizard(new Position(8, 4));

        hoard = new Hoard(new Position(10, 10));
        hoard.addEnemy(guard);
        hoard.addEnemy(spider);
        hoard.addEnemy(wizard);
    }

    @Test
    void attackSamePosition() {
        Hero hero = new Hero(new Position(10, 10), 10);

        hoard.attack(hero);

        assertEquals(4, hero.getEnergy());
    }

    @Test
    void attackNearPosition() {
        Hero hero = new Hero(new Position(9, 10), 10);

        hoard.attack(hero);

        assertEquals(7, hero.getEnergy());
    }

    @Test
    void attackFarPosition() {
        Hero hero = new Hero(new Position(8, 8), 10);

        hoard.attack(hero);

        assertEquals(10, hero.getEnergy());
    }

    @Test
    void moveHoard() {
        Hero hero = new Hero(new Position(9, 9), 10);

        hoard.moveUp();
        hoard.moveLeft();
        hoard.attack(hero);

        assertEquals(4, hero.getEnergy());
    }
}