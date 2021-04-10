package com.aor.decorator;

import com.aor.decorator.decorators.Hero;

public class BasicHero extends Hero {
    private Position position;
    private int energy;

    public BasicHero(Position position, int energy) {
        this.position = position;
        this.energy = energy;
    }

    @Override
    public void moveUp() {
        position.moveUp();
    }

    @Override
    public void moveRight() {
        position.moveRight();
    }

    @Override
    public void moveDown() {
        position.moveDown();
    }

    @Override
    public void moveLeft() {
        position.moveLeft();
    }

    @Override
    public void attack(Monster monster) {
        monster.decreaseEnergy(1);
    }

    @Override
    public void defend(Monster monster) {
        this.energy -= monster.getStrength();
    }

    @Override
    protected void decreaseEnergy(int ammount) {
        this.energy -= ammount;
    }

    public int getEnergy() {
        return energy;
    }
}
