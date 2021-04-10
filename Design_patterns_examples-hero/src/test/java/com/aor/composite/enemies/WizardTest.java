package com.aor.composite.enemies;

import com.aor.composite.Hero;
import com.aor.composite.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WizardTest {

    @Test
    void attackSamePosition() {
        Hero hero = new Hero(new Position(10, 10), 10);
        Wizard wizard = new Wizard(new Position(10, 10));

        wizard.attack(hero);

        assertEquals(7, hero.getEnergy());
    }

    @Test
    void attackNearPosition() {
        Hero hero = new Hero(new Position(9, 10), 10);
        Wizard wizard = new Wizard(new Position(10, 10));

        wizard.attack(hero);

        assertEquals(7, hero.getEnergy());
    }

    @Test
    void attackFarPosition() {
        Hero hero = new Hero(new Position(5, 5), 10);
        Wizard wizard = new Wizard(new Position(10, 10));

        wizard.attack(hero);

        assertEquals(10, hero.getEnergy());
    }
}