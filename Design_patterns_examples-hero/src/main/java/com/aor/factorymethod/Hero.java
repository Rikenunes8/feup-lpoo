package com.aor.factorymethod;

public class Hero {
    private int shield;
    private int energy;
    private int stamina;
    private int speed;

    public Hero(int shield, int energy, int stamina, int speed) {
        this.shield = shield;
        this.energy = energy;
        this.stamina = stamina;
        this.speed = speed;
    }

    public void decreaseStamina(int value) {
        this.stamina -= value;
    }

    public void decreaseEnergy(int value) {
        this.energy -= value;
    }

    public void decreaseShield(int value) {
        this.shield -= value;
    }

    public void decreaseSpeed(int value) {
        this.speed -= value;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getEnergy() {
        return energy;
    }

    public int getShield() {
        return shield;
    }

    public int getStamina() {
        return stamina;
    }
}
