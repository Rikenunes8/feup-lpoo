package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.Position;
import com.aor.command.potions.EnergyPotion;
import com.aor.command.potions.PoisonPotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrinkPotionCommandTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10), 10);
    }

    @Test
    void executeEnergy() {
        DrinkPotionCommand drinkPotionCommand = new DrinkPotionCommand(new EnergyPotion());
        drinkPotionCommand.execute(hero);

        assertEquals(12, hero.getEnergy());
    }

    @Test
    void executePoison() {
        DrinkPotionCommand drinkPotionCommand = new DrinkPotionCommand(new PoisonPotion());
        drinkPotionCommand.execute(hero);

        assertEquals(5, hero.getEnergy());
    }

    @Test
    void undo() {
        DrinkPotionCommand drinkEnergyPotionCommand = new DrinkPotionCommand(new EnergyPotion());
        DrinkPotionCommand drinkPoisonPotionCommand = new DrinkPotionCommand(new PoisonPotion());

        drinkPoisonPotionCommand.execute(hero);
        drinkEnergyPotionCommand.execute(hero);

        assertEquals(7, hero.getEnergy());

        drinkEnergyPotionCommand.undo(hero);
        drinkPoisonPotionCommand.undo(hero);

        assertEquals(10, hero.getEnergy());
    }
}