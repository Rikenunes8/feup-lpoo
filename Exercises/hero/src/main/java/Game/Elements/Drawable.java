package Game.Elements;

import Game.gui.GenericGUI;

public abstract class Drawable {
    protected String frontColor;
    protected String backColor;
    protected String text;
    public abstract void draw(GenericGUI gui);
}
