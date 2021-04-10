package com.aor.command;

import com.aor.command.commands.HeroCommand;
import com.aor.command.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hero {
    private final Position position;
    private final List<Weapon> inventory;
    private final Stack<HeroCommand> commands;
    private int energy;

    public Hero(Position position, int energy) {
        this.position = position;
        this.energy = energy;
        this.inventory = new ArrayList<>();
        this.commands = new Stack<>();
    }

    public void addWeapon(Weapon weapon) {
        this.inventory.add(weapon);
    }

    public void removeWeapon(Weapon weapon) {
        this.inventory.remove(weapon);
    }

    public List<Weapon> getInventory() {
        return inventory;
    }

    public Position getPosition() {
        return position;
    }

    public void moveTo(Position position) {
        this.position.moveTo(position);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void execute(HeroCommand command) {
        command.execute(this);
        commands.add(command);
    }

    public void undo() {
        HeroCommand command = commands.pop();
        command.undo(this);
    }
}
