package com.aor.composite;

public class Hero extends Element {
    private int energy;

    public Hero(Position position, int energy) {
        super(position);

        this.energy = energy;
    }

    public void decreaseEnergy(int value) {
        this.energy -= value;
    }

    public int getEnergy() {
        return energy;
    }

}
