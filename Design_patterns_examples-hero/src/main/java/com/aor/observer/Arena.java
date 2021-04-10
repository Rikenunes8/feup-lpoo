package com.aor.observer;

import com.aor.observer.enemies.Enemy;
import com.aor.observer.enemies.EnemyObserver;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final List<Enemy> enemies;

    public Arena() {
        enemies = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        enemy.addEnemyObserver(new EnemyObserver() {
            @Override
            public void energyChanged(Enemy enemy) {
                if (enemy.getEnergy() <= 0)
                    enemies.remove(enemy);
            }

            @Override
            public void positionChanged(Enemy enemy) {
                redraw();
            }
        });
    }

    void redraw() {
        // This would redraw the Arena
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
