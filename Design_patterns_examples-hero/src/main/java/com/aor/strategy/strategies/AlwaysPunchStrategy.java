package com.aor.strategy.strategies;

import com.aor.strategy.Hero;
import com.aor.strategy.enemies.Enemy;

public class AlwaysPunchStrategy implements AttackStrategy {
    @Override
    public void attack(Enemy enemy, Hero hero) {
        enemy.punch(hero);
    }
}
