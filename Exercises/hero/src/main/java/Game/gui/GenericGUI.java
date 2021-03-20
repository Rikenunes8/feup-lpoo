package Game.gui;

import java.io.IOException;

public interface GenericGUI {
    enum Movement { up, down, left, right, quit, restart, nothing }
    void init() throws IOException;
    void end() throws IOException;

    Movement getMovement() throws IOException;
    void setBackgroundColor(String color);
    void setForegroundColor(String color);
    void fillRectangle(int x, int y, int width, int height);
    //String getBackgroundColor();
    void putString(int x, int y, String str);
    void enableModifiers(String modifier);
    void clearScreen();
    void refreshScreen() throws IOException;
}
