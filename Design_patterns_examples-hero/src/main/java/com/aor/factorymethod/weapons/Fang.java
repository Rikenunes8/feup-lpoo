package com.aor.factorymethod.weapons;

import com.aor.factorymethod.Hero;

public class Fang extends Weapon {
    private final int number;

    public Fang(int number) {
        this.number = number;
    }

    @Override
    public void attack(Hero hero) {
        hero.decreaseStamina(this.number);
    }
}
