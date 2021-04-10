package com.aor.decorator.decorators;

import com.aor.decorator.Monster;

public class ShieldDecorator extends HeroDecorator {
    public ShieldDecorator(Hero hero) {
        super(hero);
    }

    @Override
    public void defend(Monster monster) {
        hero.decreaseEnergy(monster.getStrength() / 2);
    }
}
