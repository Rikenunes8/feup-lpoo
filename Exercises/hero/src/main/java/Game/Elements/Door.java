package Game.Elements;

import Game.gui.GenericGUI;

public class Door extends Element{
    public Door(int x, int y) {
        super(x, y);
        this.backColor = "#5D2906";
        this.frontColor = "#D4Bb7E";
        this.text = "?";
    }

    @Override
    public void draw(GenericGUI graphics) {
        graphics.setBackgroundColor(this.backColor);
        graphics.setForegroundColor(this.frontColor);
        graphics.putString(getPosition().getX(), getPosition().getY(), this.text);
    }
}
