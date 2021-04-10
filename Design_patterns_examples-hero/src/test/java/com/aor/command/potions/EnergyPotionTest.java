package com.aor.command.potions;

import com.aor.command.Hero;
import com.aor.command.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnergyPotionTest {

    @Test
    void drink() {
        Hero hero = new Hero(new Position(10, 10), 10);

        EnergyPotion potion = new EnergyPotion();
        potion.giveTo(hero);

        assertEquals(12, hero.getEnergy());
    }
}