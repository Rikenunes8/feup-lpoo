package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;

public class Guard extends Enemy {
    public Guard(Position position) {
        super(position);
    }

    @Override
    public void attack(Hero hero) {
        if (hero.getPosition().equals(getPosition()))
            hero.decreaseEnergy(1);
    }
}
