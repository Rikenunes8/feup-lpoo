package Game.Elements;

import Game.gui.GenericGUI;
import Game.utils.Position;

public abstract class Element extends Drawable {
    private Position position;
    public Element(int x, int y) {
        position = new Position(x, y);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {return position;}

    public abstract void draw(GenericGUI graphics);
}
