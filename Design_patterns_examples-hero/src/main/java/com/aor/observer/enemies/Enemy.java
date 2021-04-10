package com.aor.observer.enemies;

import com.aor.observer.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy {
    private final List<EnemyObserver> observers;

    private final Position position;
    private int energy;

    public Enemy(Position position) {
        this.energy = 0;
        this.position = position;
        this.observers = new ArrayList<>();
    }

    public void addEnemyObserver(EnemyObserver observer) {
        this.observers.add(observer);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
        for (EnemyObserver observer : observers)
            observer.energyChanged(this);
    }

    public void moveTo(Position position) {
        this.position.moveTo(position);
        for (EnemyObserver observer : observers)
            observer.positionChanged(this);
    }
}
