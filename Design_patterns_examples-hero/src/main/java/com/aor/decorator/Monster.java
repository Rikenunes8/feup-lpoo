package com.aor.decorator;

public class Monster {
    private int energy;
    private int strength;

    public Monster(int energy, int strength) {
        this.energy = energy;
        this.strength = strength;
    }

    public void decreaseEnergy(int ammount) {
        this.energy -= ammount;
    }

    public int getStrength() {
        return strength;
    }

    public int getEnergy() {
        return energy;
    }
}
