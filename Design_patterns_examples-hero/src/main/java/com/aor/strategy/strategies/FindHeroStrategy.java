package com.aor.strategy.strategies;

import com.aor.strategy.Hero;
import com.aor.strategy.enemies.Enemy;

public class FindHeroStrategy implements MoveStrategy {
    @Override
    public void move(Enemy enemy, Hero hero) {
        if (hero.getPosition().equals(enemy.getPosition())) return;

        if (Math.random() < 0.5) {
            int distance = hero.getPosition().getX() - enemy.getPosition().getX();
            if ((distance > 0)) enemy.moveRight();
            else enemy.moveLeft();
        } else {
            int distance = hero.getPosition().getY() - enemy.getPosition().getY();
            if (distance > 0) enemy.moveDown();
            else enemy.moveUp();
        }
    }
}
