package com.aor.command.potions;

import com.aor.command.Hero;
import com.aor.command.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PoisonPotionTest {

    @Test
    void drink() {
        Hero hero = new Hero(new Position(10, 10), 10);

        PoisonPotion potion = new PoisonPotion();
        potion.giveTo(hero);

        assertEquals(5, hero.getEnergy());
    }
}