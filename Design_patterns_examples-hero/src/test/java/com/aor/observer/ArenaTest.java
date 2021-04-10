package com.aor.observer;

import com.aor.observer.enemies.Spider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArenaTest {

    @Test
    void addEnemy() {
        Arena arena = new Arena();

        Spider spider1 = new Spider(new Position(10, 10));
        Spider spider2 = new Spider(new Position(10, 10));

        arena.addEnemy(spider1);
        arena.addEnemy(spider2);

        assertEquals(2, arena.getEnemies().size());
    }

    @Test
    void enemyDies() {
        Arena arena = new Arena();

        Spider spider1 = new Spider(new Position(10, 10));
        Spider spider2 = new Spider(new Position(10, 10));

        arena.addEnemy(spider1);
        arena.addEnemy(spider2);

        spider1.setEnergy(0);
        assertEquals(1, arena.getEnemies().size());

        spider2.setEnergy(5);
        assertEquals(1, arena.getEnemies().size());

        spider2.setEnergy(0);
        assertEquals(0, arena.getEnemies().size());
    }

    @Test
    void enemyMoves() {
        // Using a spy as we just want to verify if redraw is called
        // without changing the original Arena class behavior.
        Arena arena = Mockito.spy(Arena.class);

        Spider spider1 = new Spider(new Position(10, 10));
        Spider spider2 = new Spider(new Position(10, 10));
        arena.addEnemy(spider1);
        arena.addEnemy(spider2);

        Mockito.verify(arena, Mockito.never()).redraw();

        spider1.moveTo(new Position(5, 5));
        Mockito.verify(arena, Mockito.times(1)).redraw();
    }

}