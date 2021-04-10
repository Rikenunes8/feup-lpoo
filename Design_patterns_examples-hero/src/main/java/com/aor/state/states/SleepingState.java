package com.aor.state.states;

import com.aor.state.Hero;

public class SleepingState extends HeroState {
    private int timeLeft;

    public SleepingState(Hero hero) {
        super(hero);
        this.timeLeft = 8;
    }

    @Override
    public void moveUp() { }

    @Override
    public void moveRight() { }

    @Override
    public void moveDown() { }

    @Override
    public void moveLeft() { }

    @Override
    public void drinkPotion() { }

    @Override
    public void eatFood() { }

    @Override
    public void timePasses() {
        timeLeft--;
        if (timeLeft <= 0) {
            hero.increaseEnergy(10);
            hero.setState(new NormalState(hero));
        }
    }
}