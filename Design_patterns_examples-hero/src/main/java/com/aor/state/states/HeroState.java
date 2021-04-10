package com.aor.state.states;

import com.aor.state.Hero;

public abstract class HeroState {
    protected final Hero hero;

    public HeroState(Hero hero) {
        this.hero = hero;
    }

    public abstract void moveUp();

    public abstract void moveRight();

    public abstract void moveDown();

    public abstract void moveLeft();

    public abstract void drinkPotion();

    public abstract void eatFood();

    public abstract void timePasses();
}
