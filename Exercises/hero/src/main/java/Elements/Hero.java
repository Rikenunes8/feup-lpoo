package Elements;

import Elements.Element;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {
    private int energy;
    private int score;

    public Hero(int x, int y) {
        super(x, y);
        this.energy = 100;
    }

    public Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY()-1);
    }
    public Position moveDown() {
        return new Position(getPosition().getX(), getPosition().getY()+1);
    }
    public Position moveLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    public Position moveRight() {
        return new Position(getPosition().getX()+1, getPosition().getY());
    }

    public int getScore() {
        return score;
    }
    public int getEnergy() {
        return energy;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }


    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF00FF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "H");
    }
}