package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.potions.Potion;

public class DrinkPotionCommand extends HeroCommand {
    private final Potion potion;
    private Integer originalEnergy;

    public DrinkPotionCommand(Potion potion) {
        this.potion = potion;
    }

    @Override
    public void execute(Hero hero) {
        originalEnergy = hero.getEnergy();
        potion.giveTo(hero);
    }

    @Override
    public void undo(Hero hero) {
        if (this.originalEnergy != null) hero.setEnergy(this.originalEnergy);
    }
}
