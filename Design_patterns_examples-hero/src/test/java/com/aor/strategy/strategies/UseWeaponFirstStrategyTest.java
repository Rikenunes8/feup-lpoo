package com.aor.strategy.strategies;

import com.aor.strategy.Hero;
import com.aor.strategy.Position;
import com.aor.strategy.enemies.Spider;
import com.aor.strategy.weapons.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UseWeaponFirstStrategyTest {
    private Hero hero;
    private Spider spider;

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10), 10);
        spider = new Spider(new Position(10, 10), null, new UseWeaponFirstStrategy());
    }

    @Test
    void noWeapon() {
        spider.attack(hero);

        assertEquals(9, hero.getEnergy());
    }

    @Test
    void weapon() {
        spider.pick(new Sword());

        spider.attack(hero);

        assertEquals(8, hero.getEnergy());
    }

}