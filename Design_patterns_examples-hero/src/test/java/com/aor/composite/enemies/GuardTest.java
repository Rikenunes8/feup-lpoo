package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuardTest {

    @Test
    void attackSamePosition() {
        Hero hero = new Hero(new Position(10, 10), 10);
        Guard guard = new Guard(new Position(10, 10));

        guard.attack(hero);

        assertEquals(9, hero.getEnergy());
    }

    @Test
    void attackDifferentPosition() {
        Hero hero = new Hero(new Position(9, 10), 10);
        Guard guard = new Guard(new Position(10, 10));

        guard.attack(hero);

        assertEquals(10, hero.getEnergy());
    }
}