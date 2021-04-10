package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.Position;
import com.aor.command.weapons.Staff;
import com.aor.command.weapons.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PickWeaponCommandTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10), 10);
    }

    @Test
    void execute() {
        PickWeaponCommand pickWeaponCommand = new PickWeaponCommand(new Sword());
        pickWeaponCommand.execute(hero);

        assertEquals(1, hero.getInventory().size());
    }

    @Test
    void undo() {
        PickWeaponCommand pickWeaponCommand1 = new PickWeaponCommand(new Sword());
        PickWeaponCommand pickWeaponCommand2 = new PickWeaponCommand(new Staff());

        pickWeaponCommand1.execute(hero);
        pickWeaponCommand2.execute(hero);

        assertEquals(2, hero.getInventory().size());

        pickWeaponCommand2.undo(hero);
        assertEquals(1, hero.getInventory().size());

        pickWeaponCommand1.undo(hero);
        assertEquals(0, hero.getInventory().size());
    }
}