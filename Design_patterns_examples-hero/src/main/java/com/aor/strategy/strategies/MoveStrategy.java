package com.aor.strategy.strategies;

import com.aor.strategy.Hero;
import com.aor.strategy.enemies.Enemy;

public interface MoveStrategy {
    void move(Enemy enemy, Hero hero);
}
