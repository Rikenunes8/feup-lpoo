package com.aor.decorator.decorators;

import com.aor.decorator.Monster;

public class SwordDecorator extends HeroDecorator {
    private int swordStrength;

    public SwordDecorator(Hero hero, int swordStrength) {
        super(hero);
        this.swordStrength = swordStrength;
    }

    @Override
    public void attack(Monster monster) {
        monster.decreaseEnergy(this.swordStrength);
    }
}
