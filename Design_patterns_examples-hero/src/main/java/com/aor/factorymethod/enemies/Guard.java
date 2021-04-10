package com.aor.factorymethod.enemies;

import com.aor.factorymethod.weapons.Sword;
import com.aor.factorymethod.weapons.Weapon;

public class Guard extends Enemy {
    @Override
    protected Weapon createWeapon() {
        return new Sword();
    }
}
