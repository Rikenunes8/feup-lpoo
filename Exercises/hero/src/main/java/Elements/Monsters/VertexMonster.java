package Elements.Monsters;

import Elements.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class VertexMonster extends Monster{
    public VertexMonster(int x, int y) {super(x, y);}
    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "V");
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
}
