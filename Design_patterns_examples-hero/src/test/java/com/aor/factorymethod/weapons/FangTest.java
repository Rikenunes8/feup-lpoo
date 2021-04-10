package com.aor.factorymethod.weapons;

import com.aor.factorymethod.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FangTest {

    @Test
    void testTripleFang() {
        Hero hero = new Hero(10, 10, 10, 10);
        Fang fang = new Fang(3);

        fang.attack(hero);

        assertEquals(10, hero.getShield());
        assertEquals(10, hero.getEnergy());
        assertEquals(7, hero.getStamina());
        assertEquals(10, hero.getSpeed());
    }

    @Test
    void testDoubleFang() {
        Hero hero = new Hero(10, 10, 10, 10);
        Fang fang = new Fang(2);

        fang.attack(hero);

        assertEquals(10, hero.getShield());
        assertEquals(10, hero.getEnergy());
        assertEquals(8, hero.getStamina());
        assertEquals(10, hero.getSpeed());
    }

}