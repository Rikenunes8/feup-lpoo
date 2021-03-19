package Elements;

import Elements.Element;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {

    public Wall(int x, int y) {
        super(x, y);
    }

    public void draw(TextGraphics graphics) {
        TextColor t = graphics.getBackgroundColor();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5D2906"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#B76F20"));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "#");
        graphics.setBackgroundColor(t);
    }

}
