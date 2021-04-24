package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void execute(char command) {
        if (command == 'L') {
            rotateLeft();
        } else if (command == 'R') {
            rotateRight();
        } else if (command == 'F') {
            moveForward();
        }
    }

    private void moveForward() {
        if      (direction == 'N') row--;
        else if (direction == 'S') row++;
        else if (direction == 'W') column--;
        else if (direction == 'E') column++;
    }

    private void rotateRight() {
        if      (direction == 'N') direction = 'E';
        else if (direction == 'E') direction = 'S';
        else if (direction == 'S') direction = 'W';
        else if (direction == 'W') direction = 'N';
    }

    private void rotateLeft() {
        if      (direction == 'N') direction = 'W';
        else if (direction == 'W') direction = 'S';
        else if (direction == 'S') direction = 'E';
        else if (direction == 'E') direction = 'N';
    }
}
