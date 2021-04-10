package com.aor.command;

import com.aor.command.commands.DrinkPotionCommand;
import com.aor.command.commands.MoveToCommand;
import com.aor.command.commands.PickWeaponCommand;
import com.aor.command.potions.EnergyPotion;
import com.aor.command.weapons.Knife;
import com.aor.command.weapons.Staff;
import com.aor.command.weapons.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {

    @Test
    void addWeapon() {
        Hero hero = new Hero(new Position(10, 10), 10);

        hero.addWeapon(new Sword());
        hero.addWeapon(new Knife());
        hero.addWeapon(new Sword());
        hero.addWeapon(new Staff());

        assertEquals(4, hero.getInventory().size());
    }

    @Test
    void removeWeapon() {
        Hero hero = new Hero(new Position(10, 10), 10);

        Sword sword = new Sword();

        hero.addWeapon(sword);
        hero.addWeapon(new Knife());
        hero.addWeapon(new Sword());
        hero.addWeapon(new Staff());

        hero.removeWeapon(sword);

        assertEquals(3, hero.getInventory().size());
    }

    @Test
    void moveTo() {
        Hero hero = new Hero(new Position(10, 10), 10);

        hero.moveTo(new Position(5, 5));

        assertEquals(new Position(5, 5), hero.getPosition());
    }

    @Test
    void execute() {
        Hero hero = new Hero(new Position(10, 10), 10);

        hero.execute(new MoveToCommand(new Position(5, 5)));
        hero.execute(new DrinkPotionCommand(new EnergyPotion()));
        hero.execute(new PickWeaponCommand(new Sword()));

        assertEquals(new Position(5, 5), hero.getPosition());
        assertEquals(12, hero.getEnergy());
        assertEquals(1, hero.getInventory().size());
    }

    @Test
    void undo() {
        Hero hero = new Hero(new Position(10, 10), 10);

        hero.execute(new MoveToCommand(new Position(5, 5)));
        hero.execute(new DrinkPotionCommand(new EnergyPotion()));
        hero.execute(new PickWeaponCommand(new Sword()));

        hero.undo();
        hero.undo();
        hero.undo();

        assertEquals(new Position(10, 10), hero.getPosition());
        assertEquals(10, hero.getEnergy());
        assertEquals(0, hero.getInventory().size());
    }
}