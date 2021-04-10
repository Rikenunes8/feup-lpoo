package com.aor.strategy.strategies;

import com.aor.strategy.Hero;
import com.aor.strategy.enemies.Enemy;

public class UseWeaponFirstStrategy implements AttackStrategy {
    @Override
    public void attack(Enemy enemy, Hero hero) {
        if (enemy.hasWeapon()) enemy.getWeapon().attack(hero);
        else enemy.punch(hero);
    }
}
