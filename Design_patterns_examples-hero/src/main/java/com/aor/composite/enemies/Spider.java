package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;

public class Spider extends Enemy {
    public Spider(Position position) {
        super(position);
    }

    @Override
    public void attack(Hero hero) {
        if (hero.getPosition().equals(getPosition()))
            hero.decreaseEnergy(2);
    }
}
