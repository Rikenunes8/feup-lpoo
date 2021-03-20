package Game.Elements.Monsters;

import Game.Elements.Position;

import Game.gui.GenericGUI;

import java.util.Random;

public class King extends Enemy {
    public King(int x, int y) {
        super(x, y, 20);
        this.frontColor = "#00FFFF";
        this.text = "V";
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
    private Position moveUpLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY()-1);
    }
    private Position moveDownLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY()+1);
    }
    private Position moveUpRight() {
        return new Position(getPosition().getX()+1, getPosition().getY()-1);
    }
    private Position moveDownRight() {
        return new Position(getPosition().getX()+1, getPosition().getY()+1);
    }

    public Position move() {
        Random random = new Random();
        int n = random.nextInt(8);
        switch (n) {
            case 0: return moveUp();
            case 1: return moveDown();
            case 2: return moveLeft();
            case 3: return moveRight();
            case 4: return moveUpLeft();
            case 5: return moveDownLeft();
            case 6: return moveUpRight();
            default: return moveDownRight();
        }
    }

    @Override
    public int getDamage() {
        return 0;
    }
}
