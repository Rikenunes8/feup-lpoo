import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Game {
    private Screen screen;
    private Arena arena;


    public Game() throws  IOException, FileNotFoundException{
        //arena = new Arena(40, 20);
        arena = new Arena("files//rooms//room");
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);

        this.screen.setCursorPosition(null);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();
    }

    private void draw() throws IOException {
        this.screen.clear();
        arena.draw(this.screen.newTextGraphics());
        this.screen.refresh();
    }

    public void run() throws IOException, InterruptedException {
        boolean end = false;
        while (!end) {
            this.draw();
            KeyStroke key = this.screen.readInput();
            if (key.getKeyType() == KeyType.EOF ||
                    (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'))
                break;
            processKey(key);
            if (gameEnd() == 1 || gameEnd() == 2) {
                end = true;
                this.draw();
                arena.endDraw(this.screen.newTextGraphics(), gameEnd()==2);
                this.screen.refresh();
                TimeUnit.SECONDS.sleep(2);
            }
        }

        this.screen.close();
    }
    private void processKey(KeyStroke key) {
        arena.proccesKey(key);
    }

    private int gameEnd() {
        if (arena.isHeroDead())
            return 1;
        else if (arena.allCoinsCollected())
            return 2;
        else
            return 0;
    }

}
