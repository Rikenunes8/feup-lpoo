package Elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Door extends Element{
    public Door(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        TextColor t = graphics.getBackgroundColor();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5D2906"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#D4Bb7E"));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "?");
        graphics.setBackgroundColor(t);
    }
}
