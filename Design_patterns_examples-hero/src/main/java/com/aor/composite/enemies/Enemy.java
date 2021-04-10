package com.aor.composite.enemies;

import com.aor.composite.Element;
import com.aor.composite.Hero;
import com.aor.composite.Position;

public abstract class Enemy extends Element {
    public Enemy(Position position) {
        super(position);
    }

    public abstract void attack(Hero hero);
}
