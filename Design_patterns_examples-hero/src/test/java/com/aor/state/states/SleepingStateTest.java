package com.aor.state.states;

import com.aor.state.Hero;
import com.aor.state.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SleepingStateTest {
    private SleepingState state;
    private Hero hero;
    private Position position;

    @BeforeEach
    void setUp() {
        hero = Mockito.mock(Hero.class);
        position = Mockito.mock(Position.class);
        state = new SleepingState(hero);

        Mockito.when(hero.getPosition()).thenReturn(position);
    }

    @Test
    void move() {
        state.moveUp();
        Mockito.verify(position, Mockito.never()).moveUp();
    }

    @Test
    void eatFood() {
        state.eatFood();
        Mockito.verify(hero, Mockito.never()).increaseEnergy(Mockito.anyInt());
    }

    @Test
    void timePasses() {
        state.timePasses();
        Mockito.verify(hero, Mockito.never()).decreaseEnergy();
    }

    @Test
    void wakeUp() {
        for (int i = 0; i < 8; i++)
            state.timePasses();

        Mockito.verify(hero, Mockito.times(1)).setState(Mockito.any(NormalState.class));
    }

    @Test
    void drinkPotion() {
        state.drinkPotion();
        Mockito.verify(hero, Mockito.never()).setState(Mockito.any(PumpedState.class));
    }
}