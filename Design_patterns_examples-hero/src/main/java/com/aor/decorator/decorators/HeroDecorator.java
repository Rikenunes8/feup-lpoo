package com.aor.decorator.decorators;

import com.aor.decorator.Monster;

public class HeroDecorator extends Hero {
    protected Hero hero;

    public HeroDecorator(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void moveUp() {
        hero.moveUp();
    }

    @Override
    public void moveRight() {
        hero.moveRight();
    }

    @Override
    public void moveDown() {
        hero.moveDown();
    }

    @Override
    public void moveLeft() {
        hero.moveLeft();
    }

    @Override
    public void attack(Monster monster) {
        hero.attack(monster);
    }

    @Override
    public void defend(Monster monster) {
        hero.defend(monster);
    }

    @Override
    protected void decreaseEnergy(int ammount) {
        hero.decreaseEnergy(ammount);
    }

    @Override
    protected int getEnergy() {
        return hero.getEnergy();
    }
}
