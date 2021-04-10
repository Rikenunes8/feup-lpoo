package com.aor.factorymethod.enemies;

import com.aor.factorymethod.weapons.Fang;
import com.aor.factorymethod.weapons.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SpiderTest {

    @Test
    void createWeapon() {
        Spider spider = new Spider();

        Weapon weapon = spider.createWeapon();

        assertTrue(weapon instanceof Fang);
    }

}