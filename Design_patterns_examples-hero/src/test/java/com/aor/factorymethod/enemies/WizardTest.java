package com.aor.factorymethod.enemies;

import com.aor.factorymethod.weapons.Staff;
import com.aor.factorymethod.weapons.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WizardTest {

    @Test
    void createWeapon() {
        Wizard wizard = new Wizard();

        Weapon weapon = wizard.createWeapon();

        assertTrue(weapon instanceof Staff);
    }

}