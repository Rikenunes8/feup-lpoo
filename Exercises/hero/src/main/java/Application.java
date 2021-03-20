import Game.Game;
import Game.gui.LanternaGUI;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game(new LanternaGUI());
            game.run();
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
