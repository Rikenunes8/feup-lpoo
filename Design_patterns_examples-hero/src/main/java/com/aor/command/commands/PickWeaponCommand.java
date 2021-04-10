package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.weapons.Weapon;

public class PickWeaponCommand extends HeroCommand {
    private final Weapon weapon;

    public PickWeaponCommand(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void execute(Hero hero) {
        hero.addWeapon(this.weapon);
    }

    @Override
    public void undo(Hero hero) {
        hero.removeWeapon(this.weapon);
    }
}
