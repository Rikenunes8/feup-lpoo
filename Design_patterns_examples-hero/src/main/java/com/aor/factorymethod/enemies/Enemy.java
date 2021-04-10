package com.aor.factorymethod.enemies;

import com.aor.factorymethod.Hero;
import com.aor.factorymethod.weapons.Weapon;

public abstract class Enemy {
    private final Weapon weapon;

    /**
     * The constructor calls createWeapon to create
     * this enemy's weapon. Which one depends on the
     * concrete subclass.
     */
    public Enemy() {
        this.weapon = createWeapon();
    }

    /**
     * This is the factory method. It let's sub-classes
     * define which type of weapon to create.
     */
    protected abstract Weapon createWeapon();

    /**
     * The attack method attacks a hero with whatever weapon
     * this hero has.
     *
     * @param hero The attacked hero.
     */
    public void attack(Hero hero) {
        weapon.attack(hero);
    }
}
