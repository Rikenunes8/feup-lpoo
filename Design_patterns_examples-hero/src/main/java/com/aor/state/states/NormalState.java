package com.aor.state.states;

import com.aor.state.Hero;

public class NormalState extends HeroState {
    public NormalState(Hero hero) {
        super(hero);
    }

    @Override
    public void moveUp() {
        hero.getPosition().moveUp();
    }

    @Override
    public void moveRight() {
        hero.getPosition().moveRight();
    }

    @Override
    public void moveDown() {
        hero.getPosition().moveDown();
    }

    @Override
    public void moveLeft() {
        hero.getPosition().moveLeft();
    }

    @Override
    public void drinkPotion() {
        hero.setState(new PumpedState(hero));
    }

    @Override
    public void eatFood() {
        hero.increaseEnergy(10);
    }

    @Override
    public void timePasses() {
        hero.decreaseEnergy();
        if (hero.getEnergy() <= 0) hero.setState(new SleepingState(hero));
    }
}
