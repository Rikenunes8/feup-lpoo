package Game.Elements.Monsters;

import Game.utils.Position;

import Game.gui.GenericGUI;

import java.util.Random;

public class Tower extends Enemy {
    public Tower(int x, int y) {
        super(x, y, 10);
        this.frontColor = "#00FFFF";
        this.text = "A";
    }
    @Override
    public void draw(GenericGUI graphics) {
        graphics.setForegroundColor(this.frontColor);
        graphics.enableModifiers("BOLD");
        graphics.putString(getPosition().getX(), getPosition().getY(), this.text);
    }

    private Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY()-1);
    }
    private Position moveDown() {
        return new Position(getPosition().getX(), getPosition().getY()+1);
    }
    private Position moveLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    private Position moveRight() {
        return new Position(getPosition().getX()+1, getPosition().getY());
    }

    public Position move() {
        Random random = new Random();
        int n = random.nextInt(4);
        switch (n) {
            case 0:
                return moveUp();
            case 1:
                return moveDown();
            case 2:
                return moveLeft();
            default:
                return moveRight();
        }
    }
}
