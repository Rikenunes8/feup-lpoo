package Game.Elements;

import Game.gui.GenericGUI;

public class Coin extends Element {
    public Coin(int x, int y) {
        super(x, y);
        this.frontColor = "#FFFF33";
        this.text = "O";
    }

    @Override
    public void draw(GenericGUI graphics) {
        graphics.setForegroundColor(this.frontColor);
        graphics.putString(getPosition().getX(), getPosition().getY(), this.text);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coin coin = (Coin) obj;
        return this.getPosition().equals(coin.getPosition());
    }
}
