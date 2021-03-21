package Game.arena;

import Game.gui.GenericGUI;

import java.io.IOException;

public class ArenaDrawer {
    public void draw(Arena arena, GenericGUI graphics) throws IOException {
        graphics.setBackgroundColor("#5D2906");
        graphics.fillRectangle(0, 0, arena.width, arena.height+2);
        arena.getRooms().get(arena.getRoom()).draw(graphics);
        arena.getHero().draw(graphics);

        graphics.setBackgroundColor("#5D2906");
        graphics.setForegroundColor("#FFFFFF");
        graphics.putString(0, arena.getHeight(), "Score: " + arena.getHero().getScore());

        if (arena.getWin()) {
            graphics.setForegroundColor("#00FF00");
            graphics.putString(0, arena.getHeight()+1, "Winer! :)");
        } else if (arena.getGameOver()) {
            graphics.setForegroundColor("#FF0000");
            graphics.putString(0, arena.getHeight()+1, "Loser... :(");
        } else {
            graphics.putString(0, arena.getHeight()+1, "Energy: " + arena.getHero().getEnergy());
        }

    }
}
