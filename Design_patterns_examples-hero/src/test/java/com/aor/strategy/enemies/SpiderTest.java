package com.aor.strategy.enemies;

import com.aor.strategy.Hero;
import com.aor.strategy.Position;
import com.aor.strategy.strategies.AlwaysPunchStrategy;
import com.aor.strategy.strategies.FindHeroStrategy;
import com.aor.strategy.strategies.UseWeaponFirstStrategy;
import com.aor.strategy.weapons.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiderTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero(new Position(10, 10), 10);
    }

    @Test
    void testSpiderWithSword() {
        Spider spider = new Spider(new Position(5, 5), new FindHeroStrategy(), new UseWeaponFirstStrategy());
        spider.pick(new Sword());

        // Spider should find hero in less than 20 moves
        int remaining = 20;
        while (remaining-- > 0 && !spider.getPosition().equals(hero.getPosition()))
            spider.move(hero);

        // 5 attacks from the sword should be enough
        for (int i = 0; i < 5; i++)
            spider.attack(hero);

        assertEquals(0, hero.getEnergy());
    }

    @Test
    void testSpiderWithoutSword() {
        Spider spider = new Spider(new Position(5, 5), new FindHeroStrategy(), new UseWeaponFirstStrategy());

        // Spider should find hero in less than 20 moves
        int remaining = 20;
        while (remaining-- > 0 && !spider.getPosition().equals(hero.getPosition()))
            spider.move(hero);

        // 5 punches should not be enough
        for (int i = 0; i < 5; i++)
            spider.attack(hero);

        assertEquals(5, hero.getEnergy());
    }

    @Test
    void punchySpider() {
        Spider spider = new Spider(new Position(5, 5), new FindHeroStrategy(), new AlwaysPunchStrategy());
        spider.pick(new Sword());

        // Spider should find hero in less than 20 moves
        int remaining = 20;
        while (remaining-- > 0 && !spider.getPosition().equals(hero.getPosition()))
            spider.move(hero);

        // should punch even with a sword
        for (int i = 0; i < 5; i++)
            spider.attack(hero);

        assertEquals(5, hero.getEnergy());
    }
}