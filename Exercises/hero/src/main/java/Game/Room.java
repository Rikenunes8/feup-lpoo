package Game;

import Game.Elements.*;
import Game.Elements.Monsters.Tower;
import Game.Elements.Monsters.Enemy;
import Game.Elements.Monsters.King;

import Game.gui.GenericGUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Room extends Drawable {
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Enemy> enemies;
    private List<Door> doors;


    public Room(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins(10);
        this.enemies = createMonsters(20);
        this.backColor = color;
    }
    // Creators
    private List<Enemy> createMonsters(int nMonsters) {
        Random random = new Random();
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < nMonsters; i++) {
            if (random.nextInt(2) == 0)
                enemies.add(new Tower(random.nextInt(width-2)+1, random.nextInt(height-2)+1));
            else
                enemies.add(new King(random.nextInt(width-2)+1, random.nextInt(height-2)+1));
        }
        return enemies;
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }

        for (int r = 1; r < height-1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width-1, r));
        }
        return walls;
    }
    private List<Coin> createCoins(int nCoins) {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < nCoins; i++) {
            Coin coin;
            do {
                coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            } while (coins.contains(coin));
            coins.add(coin);
        }
        return coins;
    }


    public Room(String path) throws FileNotFoundException {
        walls = new ArrayList<>();
        coins = new ArrayList<>();
        enemies = new ArrayList<>();
        doors = new ArrayList<>();
        readArena(path);
    }
    public void readArena(String path) throws FileNotFoundException {
        int line = 0;
        File arenaFile = new File(path);
        Scanner reader = new Scanner(arenaFile);
        String width = reader.nextLine();
        String height = reader.nextLine();
        String color = reader.nextLine();
        this.width = Integer.parseInt(width);
        this.height = Integer.parseInt(height);
        this.backColor = color;
        while  (reader.hasNextLine()) {
            String data = reader.nextLine();
            for (int col = 0; col < data.length(); col++) {
                switch (data.charAt(col)) {
                    case '#':
                        walls.add(new Wall(col, line));
                        break;
                    case '?':
                        doors.add(new Door(col, line));
                        break;
                    case 'O':
                        coins.add(new Coin(col, line));
                        break;
                    case 'A':
                        enemies.add(new Tower(col, line));
                        break;
                    case 'V':
                        enemies.add(new King(col, line));
                        break;
                    default:
                        break;
                }
            }
            line++;
        }
    }

    public Position getDimensions() {
        return new Position(width, height);
    }

    public void draw(GenericGUI graphics) {
        graphics.setBackgroundColor(this.backColor);
        graphics.fillRectangle(0, 0, this.width, this.height);
        for (Wall wall:walls)
            wall.draw(graphics);
        for (Door door:doors)
            door.draw(graphics);
        graphics.setBackgroundColor(this.backColor);
        for (Coin coin:coins)
            coin.draw(graphics);
        for (Enemy enemy : enemies)
            enemy.draw(graphics);
    }



    public boolean retrieveCoins(Position position) {
        for (Coin coin:coins) {
            if (coin.getPosition().equals(position)){
                coins.remove(coin);
                return true;
            }
        }
        return false;
    }

    public boolean canHeroMove(Position position) {
        for (Wall wall:walls)
            if (wall.getPosition().equals(position))
                return false;
        for (Door door:doors)
            if (door.getPosition().equals(position))
                return false;
        if (position.getX() > width-1 || position.getY() > height-1)
            return false;
        return true;
    }

    public int doorAvailable(Position position) {
        for (int i = 0; i < doors.size(); i++)
            if (doors.get(i).getPosition().equals(position) &&
                allCoinsCollected())
                return i;
        return -1;
    }

    public Position getDoorPosition(int i) {
        return doors.get(i).getPosition();
    }

    public void moveMonsters() {
        for (Enemy enemy : enemies) {
            Position pos = enemy.move();
            if (canHeroMove(pos)) {
                enemy.setPosition(pos);
            }
        }
    }

    public int verifiyMonstersPosition(Position position) {
        int damage = 0;
        for (Enemy enemy : enemies) {
            if (enemy.verifyMonsterPosition(position))
                damage += enemy.getDamage();
        }
        return damage;
    }

    public boolean allCoinsCollected() {
        return coins.isEmpty();
    }
}
