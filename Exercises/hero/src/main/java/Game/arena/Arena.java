package Game.arena;

import Game.Elements.Hero;
import Game.utils.Position;

import Game.gui.GenericGUI.Movement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    public int width;
    public int height;
    private Hero hero;
    private List<Room> rooms;
    private int room = 0;
    private boolean gameOver = false;
    private boolean win = false;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 10);
        rooms = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            rooms.add(new Room(width, height, "#228B22"));
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
            pos = new Position(random.nextInt(width), random.nextInt(height)+2);
        } while (!canHeroMove(pos));
        hero.setPosition(pos);
    }

    public void step(Movement movement) {
        switch (movement) {
            case up:
            case down:
            case left:
            case right:
                moveHero(hero.move(movement));
                moveMonsters();
                updateDamage();
                break;

        }
    }

    public List<Room> getRooms() {
        return rooms;
    }
    public int getRoom() {
        return room;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Hero getHero() {
        return hero;
    }
    public boolean getGameOver() {return gameOver;}
    public boolean getWin() {return win;}


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
    public void updateDamage() {
        int damage = rooms.get(room).verifiyMonstersPosition(hero.getPosition());
        hero.decreaseEnergy(damage);
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
        gameOver = hero.getEnergy() <= 0;
        return gameOver;
    }
    public boolean allCoinsCollected() {
        win = true;
        for (Room room:rooms) {
            if (!room.allCoinsCollected()) {
                win = false;
                break;
            }

        }
        return win;
    }
}
