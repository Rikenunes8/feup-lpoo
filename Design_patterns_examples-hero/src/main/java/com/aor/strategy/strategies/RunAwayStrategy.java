package com.aor.strategy.strategies;

import com.aor.strategy.Hero;
import com.aor.strategy.enemies.Enemy;

public class RunAwayStrategy implements MoveStrategy {
    @Override
    public void move(Enemy enemy, Hero hero) {
        if (Math.random() < 0.5) {
            int distance = hero.getPosition().getX() - enemy.getPosition().getX();
            if ((distance > 0)) enemy.moveLeft();
            else enemy.moveRight();
        } else {
            int distance = hero.getPosition().getY() - enemy.getPosition().getY();
            if (distance > 0) enemy.moveUp();
            else enemy.moveDown();
        }
    }
}
