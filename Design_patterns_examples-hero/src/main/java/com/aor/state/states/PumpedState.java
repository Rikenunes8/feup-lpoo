package com.aor.state.states;

import com.aor.state.Hero;

public class PumpedState extends HeroState {
    private int timeLeft;

    public PumpedState(Hero hero) {
        super(hero);
        this.timeLeft = 5;
    }

    @Override
    public void moveUp() {
        hero.getPosition().moveUp();
        hero.getPosition().moveUp();
    }

    @Override
    public void moveRight() {
        hero.getPosition().moveRight();
        hero.getPosition().moveRight();
    }

    @Override
    public void moveDown() {
        hero.getPosition().moveDown();
        hero.getPosition().moveDown();
    }

    @Override
    public void moveLeft() {
        hero.getPosition().moveLeft();
        hero.getPosition().moveLeft();
    }

    @Override
    public void drinkPotion() {
        this.timeLeft = 10;
    }

    @Override
    public void eatFood() {
        hero.increaseEnergy(20);
    }

    @Override
    public void timePasses() {
        hero.decreaseEnergy();
        timeLeft--;

        if (timeLeft <= 0) hero.setState(new NormalState(hero));
        if (hero.getEnergy() <= 0) hero.setState(new SleepingState(hero));
    }
}
