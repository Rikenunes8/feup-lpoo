package Game.Elements;

import Game.gui.GenericGUI;
import Game.utils.Position;

public class Hero extends Element {
    private int energy;
    private int score;

    public Hero(int x, int y) {
        super(x, y);
        this.energy = 100;
        this.frontColor = "#FF00FF";
        this.text = "H";
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

    public Position move(GenericGUI.Movement mov) {
        switch (mov) {
            case up:    return moveUp();
            case down:  return moveDown();
            case left:  return moveLeft();
            case right: return moveRight();
            default:    return getPosition();
        }
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
    public void decreaseEnergy(int damage) {
        this.energy -= damage;
    }


    public void draw(GenericGUI graphics) {
        graphics.setForegroundColor(this.frontColor);
        graphics.enableModifiers("BOLD");
        graphics.putString(getPosition().getX(), getPosition().getY(), this.text);
    }
}