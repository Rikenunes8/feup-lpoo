package com.aor.factorymethod.enemies;

import com.aor.factorymethod.weapons.Fang;
import com.aor.factorymethod.weapons.Weapon;

public class Spider extends Enemy {
    @Override
    protected Weapon createWeapon() {
        return new Fang(2);
    }
}
