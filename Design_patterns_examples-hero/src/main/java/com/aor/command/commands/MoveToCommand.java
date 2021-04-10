package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.Position;

public class MoveToCommand extends HeroCommand {
    private final Position newPosition;
    private Position oldPosition;

    public MoveToCommand(Position position) {
        this.newPosition = position;
    }

    @Override
    public void execute(Hero hero) {
        this.oldPosition = new Position(hero.getPosition().getX(), hero.getPosition().getY());
        hero.moveTo(newPosition);
    }

    @Override
    public void undo(Hero hero) {
        if (this.oldPosition != null) hero.moveTo(oldPosition);
    }
}
