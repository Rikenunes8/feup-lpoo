package com.aor.observer.enemies;

public interface EnemyObserver {
    void energyChanged(Enemy enemy);
    void positionChanged(Enemy enemy);
}
