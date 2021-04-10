package Game.Elements.Monsters;

import Game.Elements.Element;
import Game.utils.Position;

import Game.gui.GenericGUI;

public abstract class Enemy extends Element {
    private int damage;
    public Enemy(int x, int y, int damage) {
        super(x, y);
        this.damage = damage;
    }
    public abstract void draw(GenericGUI graphics);
    public abstract Position move();
    public int getDamage() {return damage;}

    public boolean verifyMonsterPosition(Position position) {
        return this.getPosition().equals(position);
    }
}
