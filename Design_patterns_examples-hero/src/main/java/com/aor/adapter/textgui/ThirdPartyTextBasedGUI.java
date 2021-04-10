package com.aor.adapter.textgui;

public class ThirdPartyTextBasedGUI {
    private String color;

    public void changeBackgroundColor(String color) {
        this.color = color;
    }

    public void drawCharacter(char c, int x, int y) {
        System.out.println("Draw character " + c + " at " + x + ", " + y + " in " + color);
    }
}
