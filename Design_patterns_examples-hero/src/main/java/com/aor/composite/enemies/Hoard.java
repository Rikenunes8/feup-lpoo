package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;

import java.util.ArrayList;
import java.util.List;

public class Hoard extends Enemy {
    private final List<Enemy> enemies;

    public Hoard(Position position) {
        super(position);
        this.enemies = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        enemy.getPosition().moveTo(this.getPosition());
    }

    @Override
    public void moveDown() {
        super.moveDown();
        for (Enemy enemy : enemies) enemy.getPosition().moveTo(getPosition());
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        for (Enemy enemy : enemies) enemy.getPosition().moveTo(getPosition());
    }

    @Override
    public void moveRight() {
        super.moveRight();
        for (Enemy enemy : enemies) enemy.getPosition().moveTo(getPosition());
    }

    @Override
    public void moveUp() {
        super.moveUp();
        for (Enemy enemy : enemies) enemy.getPosition().moveTo(getPosition());
    }

    @Override
    public void attack(Hero hero) {
        for (Enemy enemy : enemies)
            enemy.attack(hero);
    }
}
