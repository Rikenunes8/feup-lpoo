package Game.Elements;

import Game.gui.GenericGUI;

public class Wall extends Element {

    public Wall(int x, int y) {
        super(x, y);
        this.backColor = "#5D2906";
        this.frontColor = "#B76F20";
        this.text = " ";
    }

    public void draw(GenericGUI graphics) {
        graphics.setBackgroundColor(this.backColor);
        graphics.setForegroundColor(this.frontColor);
        graphics.putString(getPosition().getX(), getPosition().getY(), this.text);
    }

}
