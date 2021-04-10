package com.aor.factorymethod.weapons;

import com.aor.factorymethod.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaffTest {

    @Test
    void testAttack() {
        Hero hero = new Hero(10, 10, 10, 10);
        Staff staff = new Staff();

        staff.attack(hero);

        assertEquals(10, hero.getShield());
        assertEquals(10, hero.getEnergy());
        assertEquals(10, hero.getStamina());
        assertEquals(5, hero.getSpeed());
    }

}