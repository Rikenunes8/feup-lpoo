import Elements.Wall;
import Elements.Coin;
import Elements.Door;
import Elements.Position;
import Elements.Monsters.AdjacentMonster;
import Elements.Monsters.Monster;
import Elements.Monsters.VertexMonster;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Room {
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private List<Door> doors;


    public Room(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins(10);
        this.monsters = createMonsters(20);
    }

    public Room(String path) throws FileNotFoundException {
        walls = new ArrayList<>();
        coins = new ArrayList<>();
        monsters = new ArrayList<>();
        doors = new ArrayList<>();
        readArena(path);
    }
    public void readArena(String path) throws FileNotFoundException {
        int line = 0;
        File arenaFile = new File(path);
        Scanner reader = new Scanner(arenaFile);
        String width = reader.nextLine();
        String height = reader.nextLine();
        this.width = Integer.parseInt(width);
        this.height = Integer.parseInt(height);

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
                        monsters.add(new AdjacentMonster(col, line));
                        break;
                    case 'V':
                        monsters.add(new VertexMonster(col, line));
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

    public void draw(TextGraphics graphics) {
        for (Wall wall:walls)
            wall.draw(graphics);
        for (Door door:doors)
            door.draw(graphics);
        for (Coin coin:coins)
            coin.draw(graphics);
        for (Monster monster:monsters)
            monster.draw(graphics);
    }

    private List<Monster> createMonsters(int nMonsters) {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < nMonsters; i++) {
            if (random.nextInt(2) == 0)
                monsters.add(new AdjacentMonster(random.nextInt(width-2)+1, random.nextInt(height-2)+1));
            else
                monsters.add(new VertexMonster(random.nextInt(width-2)+1, random.nextInt(height-2)+1));
        }
        return monsters;
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
            if (doors.get(i).getPosition().equals(position))
                return i;
        return -1;
    }

    public Position getDoorPosition(int i) {
        return doors.get(i).getPosition();
    }

    public void moveMonsters() {
        for (Monster monster:monsters) {
            Position pos = monster.move();
            if (canHeroMove(pos)) {
                monster.setPosition(pos);
            }
        }
    }

    public boolean verifiyMonstersPosition(Position position) {
        for (Monster monster:monsters) {
            if (monster.verifyMonsterPosition(position))
                return true;
        }
        return false;
    }

    public boolean allCoinsCollected() {
        return coins.isEmpty();
    }
}
