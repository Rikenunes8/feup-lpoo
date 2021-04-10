package com.aor.adapter.adapters;

import com.aor.adapter.Hero;
import com.aor.adapter.Screen;
import com.aor.adapter.graphicsgui.ThirdPartyGraphicsBasedGUI;

public class GraphicsAdapter implements Screen {
    private final ThirdPartyGraphicsBasedGUI gui;

    public GraphicsAdapter(ThirdPartyGraphicsBasedGUI gui) {
        this.gui = gui;
    }

    @Override
    public void drawHero(Hero hero) {
        gui.drawHeroSprite(hero.getPosition().getX() * 10.0, hero.getPosition().getY() * 10.0);
    }
}
