package Game;

import Game.gui.GenericGUI;
import Game.gui.GenericGUI.Movement;

import java.io.IOException;

public class Game {
    public enum State {
        CONTINUE,
        WIN,
        LOSE,
        QUIT,
        RESTART
    }
    private final GenericGUI gui;
    private Arena arena;
    private final ArenaDrawer arenaDrawer;
    private State state;
    private final String arenaPath;


    public Game(GenericGUI gui) throws  IOException {
        //arenaPath = "files//rooms//room";
        arenaPath = "files//rooms2//room";
        /*
          |U|         |1|
        |L|C|R|     |2|0|3|
          |D|         |4|
         */
        this.state = State.CONTINUE;
        //arena = new Game.Arena(40, 20);
        arena = new Arena(arenaPath);
        arenaDrawer = new ArenaDrawer();
        this.gui = gui;
        this.gui.init();

    }

    private void draw() throws IOException {
        this.gui.clearScreen();
        arenaDrawer.draw(this.arena, this.gui);
        this.gui.refreshScreen();
    }

    public void run() throws IOException, InterruptedException {
        while (state != State.QUIT) {
            this.draw();

            gameAction();
            updateState();

            if (state == State.WIN || state == State.LOSE) {
                arenaDrawer.draw(this.arena, this.gui);
                this.gui.refreshScreen();

                while (state != State.RESTART && state != State.QUIT) {
                    gameAction();
                }
            }
            if (state == State.RESTART) {
                arena = new Arena(arenaPath);
                state = State.CONTINUE;
            }
        }

        this.gui.end();
    }

    private void gameAction() throws IOException {
        GenericGUI.Movement movement = this.gui.getMovement();
        if (movement == Movement.quit)
            state = State.QUIT;
        else if (movement == Movement.restart)
            state = State.RESTART;
        else if (movement != Movement.nothing)
            arena.step(movement);
    }

    private void updateState() {
        if (arena.isHeroDead())
            state = State.LOSE;
        else if (arena.allCoinsCollected())
            state = State.WIN;;
    }

}
