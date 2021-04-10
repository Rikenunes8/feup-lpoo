package com.aor.factorymethod.weapons;

import com.aor.factorymethod.Hero;

public class Sword extends Weapon {
    @Override
    public void attack(Hero hero) {
        hero.decreaseEnergy(2);
        hero.decreaseShield(1);
    }
}
