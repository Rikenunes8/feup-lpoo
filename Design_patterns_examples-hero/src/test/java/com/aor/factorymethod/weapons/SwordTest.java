package com.aor.factorymethod.weapons;

import com.aor.factorymethod.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwordTest {

    @Test
    void testAttack() {
        Hero hero = new Hero(10, 10, 10, 10);
        Sword sword = new Sword();

        sword.attack(hero);

        assertEquals(9, hero.getShield());
        assertEquals(8, hero.getEnergy());
        assertEquals(10, hero.getStamina());
        assertEquals(10, hero.getSpeed());
    }

}