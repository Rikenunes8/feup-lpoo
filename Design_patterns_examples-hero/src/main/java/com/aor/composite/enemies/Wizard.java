package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;

public class Wizard extends Enemy {
    public Wizard(Position position) {
        super(position);
    }

    @Override
    public void attack(Hero hero) {
        if (hero.getPosition().distanceTo(getPosition()) <= 2)
            hero.decreaseEnergy(3);
    }
}
