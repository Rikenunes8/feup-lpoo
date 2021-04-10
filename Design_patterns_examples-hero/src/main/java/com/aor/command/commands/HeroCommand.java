package com.aor.command.commands;

import com.aor.command.Hero;

public abstract class HeroCommand {
    public abstract void execute(Hero hero);

    public abstract void undo(Hero hero);
}
