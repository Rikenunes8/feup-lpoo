package com.aor.composite;

public abstract class Element {
    Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void moveUp() {
        this.position.moveUp();
    }

    public void moveRight() {
        this.position.moveRight();
    }

    public void moveDown() {
        this.position.moveDown();
    }

    public void moveLeft() {
        this.position.moveLeft();
    }
}
