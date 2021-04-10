package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiderTest {

    @Test
    void attackSamePosition() {
        Hero hero = new Hero(new Position(10, 10), 10);
        Spider spider = new Spider(new Position(10, 10));

        spider.attack(hero);

        assertEquals(8, hero.getEnergy());
    }

    @Test
    void attackDifferentPosition() {
        Hero hero = new Hero(new Position(9, 10), 10);
        Spider spider = new Spider(new Position(10, 10));

        spider.attack(hero);

        assertEquals(10, hero.getEnergy());
    }
}