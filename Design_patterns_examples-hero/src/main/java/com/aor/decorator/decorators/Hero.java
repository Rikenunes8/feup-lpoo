package com.aor.decorator.decorators;

import com.aor.decorator.Monster;

public abstract class Hero {
    public abstract void moveUp();
    public abstract void moveRight();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void attack(Monster monster);
    public abstract void defend(Monster monster);

    protected abstract void decreaseEnergy(int ammount);
    protected abstract int getEnergy();
}
