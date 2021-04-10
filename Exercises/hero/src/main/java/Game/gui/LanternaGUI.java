package Game.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI implements GenericGUI {
    Screen screen;
    TextGraphics graphics;

    @Override
    public void init() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();

        this.graphics = screen.newTextGraphics();
    }

    @Override
    public void end() throws IOException {
        this.screen.close();
    }

    @Override
    public Movement getMovement() throws IOException {
        KeyStroke key = this.screen.readInput();

        switch (key.getKeyType()) {
            case ArrowLeft: return Movement.left;
            case ArrowRight: return Movement.right;
            case ArrowUp: return Movement.up;
            case ArrowDown: return Movement.down;
            case EOF: return Movement.quit;
            case Character:
                if (key.getCharacter() == 'q') return Movement.quit;
                else if (key.getCharacter() == 'r') return Movement.restart;
            default: return Movement.nothing;
        }
    }

    @Override
    public void setBackgroundColor(String color) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
    }

    @Override
    public void setForegroundColor(String color) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
    }

    @Override
    public void fillRectangle(int x, int y, int width, int height) {
        graphics.fillRectangle(new TerminalPosition(x, y), new TerminalSize(width, height), ' ');
    }

    @Override
    public void putString(int x, int y, String str) {
        graphics.putString(new TerminalPosition(x, y), str);

    }

    @Override
    public void enableModifiers(String modifier) {
        if (modifier == "BOLD")
            graphics.enableModifiers(SGR.BOLD);
    }

    @Override
    public void clearScreen() {
        this.screen.clear();
    }

    @Override
    public void refreshScreen() throws IOException {
        this.screen.refresh();
    }
}
