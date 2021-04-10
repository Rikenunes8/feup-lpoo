package com.aor.strategy.weapons;

import com.aor.strategy.Hero;

public class Sword extends Weapon {
    @Override
    public void attack(Hero hero) {
        hero.decreaseEnergy(2);
    }
}
