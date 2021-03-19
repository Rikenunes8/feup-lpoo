import Elements.*;
import Elements.Monsters.AdjacentMonster;
import Elements.Monsters.Monster;
import Elements.Monsters.VertexMonster;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arena {
    public int width;
    public int height;
    private Hero hero;
    private List<Room> rooms;
    private int room = 0;


    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 10);
        rooms = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            rooms.add(new Room(width, height));
        }
    }

    public Arena(String path) throws FileNotFoundException {
        Position dim = new Position(0, 0);
        Position pos;
        rooms = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rooms.add(new Room(path+(i)+".txt"));
            pos = rooms.get(i).getDimensions();
            if (pos.getX() > dim.getX())
                dim.setX(pos.getX());
            if (pos.getY() > dim.getY())
                dim.setY(pos.getY());
        }
        this.width = dim.getX();
        this.height = dim.getY();
        this.hero = new Hero(0, 0);
        Random random = new Random();
        do {
            pos = new Position(random.nextInt(width), random.nextInt(height));
        } while (!canHeroMove(pos));
        hero.setPosition(pos);
    }

    public void proccesKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowLeft:
                moveHero(hero.moveLeft());
                moveMonsters();
                verifiyMonstersPosition();
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                moveMonsters();
                verifiyMonstersPosition();
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                moveMonsters();
                verifiyMonstersPosition();
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                moveMonsters();
                verifiyMonstersPosition();
                break;
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        rooms.get(room).draw(graphics);
        hero.draw(graphics);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        TextColor t = graphics.getBackgroundColor();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5D2906"));
        graphics.putString(new TerminalPosition(0, 0), "Energy: " + hero.getEnergy());
        graphics.putString(new TerminalPosition(0, height-1), "Score: " + hero.getScore());
        graphics.setBackgroundColor(t);
    }

    public void endDraw(TextGraphics graphics, boolean win) {
        TextColor t = graphics.getBackgroundColor();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(width/2-10, height/2-5), new TerminalSize(20, 8), ' ');
        if (win) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
            graphics.putString(new TerminalPosition(width / 2 - 5, height / 2), "Win");
        }
        else {
            graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
            graphics.putString(new TerminalPosition(width/2-5, height/2), "Loser");
        }
        graphics.setBackgroundColor(t);
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
            if (rooms.get(room).retrieveCoins(hero.getPosition()))
                hero.setScore(hero.getScore()+1);
        }
        int door = rooms.get(room).doorAvailable(position);
        if (door != -1)
            goToNextRoom(door);
    }

    private boolean canHeroMove(Position position) {
        return rooms.get(room).canHeroMove(position);
    }

    private void moveMonsters() {
        rooms.get(room).moveMonsters();
    }

    public void verifiyMonstersPosition() {
        if (rooms.get(room).verifiyMonstersPosition(hero.getPosition()))
            hero.setEnergy(hero.getEnergy()-20);
    }

    public void goToNextRoom(int door) {
        int nextRoom;
        Position pos;
        if (room == 0) {
            nextRoom = door+1;
            pos = rooms.get(nextRoom).getDoorPosition(0);
        }
        else {
            nextRoom = 0;
            pos = rooms.get(nextRoom).getDoorPosition(room-1);
        }
        hero.setPosition(pos);
        room = nextRoom;
    }

    public boolean isHeroDead() {
        return hero.getEnergy() <=  0;
    }

    public boolean allCoinsCollected() {
        for (Room room:rooms) {
            if (!room.allCoinsCollected())
                return false;
        }
        return true;
    }

    /*public void readArenaFile(String path) throws FileNotFoundException {
        int state = 0;
        File arenaFile = new File(path);
        Scanner reader = new Scanner(arenaFile);
        while (reader.hasNextLine()) {
            switch (state) {
                case 0:
                    this.width = reader.nextInt();
                    this.height = reader.nextInt();
                    state++;
                    break;
                case 1:
                    int n_walls = reader.nextInt();
                    for (int i = 0; i < n_walls; i++) {
                        int x = reader.nextInt();
                        int y = reader.nextInt();
                        walls.add(new Wall(x, y));
                    }
                    state++;
                    break;
                case 2:
                    int n_coins = reader.nextInt();
                    for (int i = 0; i < n_coins; i++) {
                        int x = reader.nextInt();
                        int y = reader.nextInt();
                        coins.add(new Coin(x, y));
                    }
                    state++;
                    break;
                case 3:
                    int x_hero = reader.nextInt();
                    int y_hero = reader.nextInt();
                    hero.setPosition(new Position(x_hero, y_hero));
                    state++;
                    break;
                case 4:
                    int n_adj = reader.nextInt();
                    for (int i = 0; i < n_adj; i++) {
                        int x = reader.nextInt();
                        int y = reader.nextInt();
                        monsters.add(new AdjacentMonster(x, y));
                    }
                    state++;
                    break;
                case 5:
                    int n_ver = reader.nextInt();
                    for (int i = 0; i < n_ver; i++) {
                        int x = reader.nextInt();
                        int y = reader.nextInt();
                        monsters.add(new VertexMonster(x, y));
                    }
                    state++;
                    break;
                default: reader.nextLine(); break;
            }
        }
        reader.close();

    }*/
    /*public void writeArenaFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(String.valueOf(width)+" "+String.valueOf(height));
        writer.write("\n" + String.valueOf(walls.size()));
        for (Wall wall:walls)
            writer.write(" " + String.valueOf(wall.getPosition().getX()) + " " + wall.getPosition().getY());
        writer.write("\n" + String.valueOf(coins.size()));
        for (Coin coin:coins)
            writer.write(" " + String.valueOf(coin.getPosition().getX()) + " " + coin.getPosition().getY());
        writer.write("\n" + String.valueOf(hero.getPosition().getX()) + " " + hero.getPosition().getY());
    }*/
}
