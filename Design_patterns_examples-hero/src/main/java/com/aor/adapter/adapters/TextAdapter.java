package com.aor.adapter.adapters;

import com.aor.adapter.Hero;
import com.aor.adapter.Screen;
import com.aor.adapter.textgui.ThirdPartyTextBasedGUI;

public class TextAdapter implements Screen {
    private final ThirdPartyTextBasedGUI gui;

    public TextAdapter(ThirdPartyTextBasedGUI gui) {
        this.gui = gui;
    }

    @Override
    public void drawHero(Hero hero) {
        gui.changeBackgroundColor("blue");
        gui.drawCharacter('H', hero.getPosition().getX(), hero.getPosition().getY());
    }
}
