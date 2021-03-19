package Elements.Monsters;

import Elements.Element;
import Elements.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }
    public abstract void draw(TextGraphics graphics);
    public abstract Position move();

    public boolean verifyMonsterPosition(Position position) {
        return this.getPosition().equals(position);
    }
}
