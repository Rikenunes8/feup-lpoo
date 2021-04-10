package com.aor.observer;

import com.aor.observer.enemies.EnemyObserver;
import com.aor.observer.enemies.Spider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnemyObserverTest {

    @Test
    void addEnemyObserver() {
        Spider spider = new Spider(new Position(10, 10));
        EnemyObserver observer = Mockito.mock(EnemyObserver.class);

        spider.addEnemyObserver(observer);
        Mockito.verify(observer, Mockito.never()).energyChanged(spider);

        spider.setEnergy(8);
        spider.setEnergy(5);
        Mockito.verify(observer, Mockito.times(2)).energyChanged(spider);

        spider.moveTo(new Position(5, 5));
        Mockito.verify(observer, Mockito.times(1)).positionChanged(spider);
    }

}