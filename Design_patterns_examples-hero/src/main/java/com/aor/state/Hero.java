package com.aor.state;

import com.aor.state.states.HeroState;
import com.aor.state.states.NormalState;

public class Hero {
    private final Position position;
    private HeroState state;
    private int energy;

    public Hero(Position position) {
        this.position = position;
        this.energy = 10;
        this.state = new NormalState(this);
    }

    public void setState(HeroState state) {
        this.state = state;
    }

    public Position getPosition() {
        return position;
    }

    public void moveUp() {
        state.moveUp();
    }

    public void moveRight() {
        state.moveRight();
    }

    public void moveDown() {
        state.moveDown();
    }

    public void moveLeft() {
        state.moveLeft();
    }

    public void drinkPotion() {
        state.drinkPotion();
    }

    public void eatFood() {
        state.eatFood();
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public void increaseEnergy(int ammount) {
        this.energy += ammount;
    }

    public int getEnergy() {
        return energy;
    }

    public void timePasses() {
        state.timePasses();
    }
}
