package com.aor.factorymethod.enemies;

import com.aor.factorymethod.weapons.Staff;
import com.aor.factorymethod.weapons.Weapon;

public class Wizard extends Enemy {
    @Override
    protected Weapon createWeapon() {
        return new Staff();
    }
}
