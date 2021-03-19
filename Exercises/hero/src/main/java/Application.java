import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
