package com.aor.strategy.strategies;

import com.aor.strategy.Hero;
import com.aor.strategy.enemies.Enemy;

public interface AttackStrategy {
    void attack(Enemy enemy, Hero hero);
}
