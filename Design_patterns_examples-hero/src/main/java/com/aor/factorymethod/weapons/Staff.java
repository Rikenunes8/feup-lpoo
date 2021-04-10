package com.aor.factorymethod.weapons;

import com.aor.factorymethod.Hero;

public class Staff extends Weapon {
    @Override
    public void attack(Hero hero) {
        hero.decreaseSpeed(hero.getSpeed() / 2);
    }
}
