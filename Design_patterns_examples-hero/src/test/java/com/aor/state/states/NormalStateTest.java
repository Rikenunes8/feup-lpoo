package com.aor.state.states;

import com.aor.state.Hero;
import com.aor.state.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NormalStateTest {
    private NormalState state;
    private Hero hero;
    private Position position;

    @BeforeEach
    void setUp() {
        hero = Mockito.mock(Hero.class);
        position = Mockito.mock(Position.class);
        state = new NormalState(hero);

        Mockito.when(hero.getPosition()).thenReturn(position);
    }

    @Test
    void move() {
        state.moveUp();
        Mockito.verify(position, Mockito.times(1)).moveUp();
    }

    @Test
    void eatFood() {
        state.eatFood();
        Mockito.verify(hero, Mockito.times(1)).increaseEnergy(10);
    }

    @Test
    void timePasses() {
        state.timePasses();
        Mockito.verify(hero, Mockito.times(1)).decreaseEnergy();
    }

    @Test
    void sleep() {
        Mockito.when(hero.getEnergy()).thenReturn(10);
        state.timePasses();
        Mockito.verify(hero, Mockito.never()).setState(Mockito.any(SleepingState.class));

        Mockito.when(hero.getEnergy()).thenReturn(0);
        state.timePasses();
        Mockito.verify(hero, Mockito.times(1)).setState(Mockito.any(SleepingState.class));
    }

    @Test
    void drinkPotion() {
        state.drinkPotion();
        Mockito.verify(hero, Mockito.times(1)).setState(Mockito.any(PumpedState.class));
    }
}