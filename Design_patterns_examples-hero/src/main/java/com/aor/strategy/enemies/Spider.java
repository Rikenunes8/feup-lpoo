package com.aor.strategy.enemies;

import com.aor.strategy.Position;
import com.aor.strategy.strategies.AttackStrategy;
import com.aor.strategy.strategies.MoveStrategy;

public class Spider extends Enemy {
    public Spider(Position position, MoveStrategy moveStrategy, AttackStrategy attackStrategy) {
        super(position, moveStrategy, attackStrategy);
    }
}
