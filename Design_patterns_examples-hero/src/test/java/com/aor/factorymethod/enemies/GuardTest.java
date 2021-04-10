package com.aor.factorymethod.enemies;

import com.aor.factorymethod.weapons.Sword;
import com.aor.factorymethod.weapons.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GuardTest {

    @Test
    void createWeapon() {
        Guard guard = new Guard();

        Weapon weapon = guard.createWeapon();

        assertTrue(weapon instanceof Sword);
    }

}