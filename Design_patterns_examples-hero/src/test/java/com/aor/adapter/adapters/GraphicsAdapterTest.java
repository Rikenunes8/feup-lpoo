package com.aor.adapter.adapters;

import com.aor.adapter.Hero;
import com.aor.adapter.Position;
import com.aor.adapter.Screen;
import com.aor.adapter.graphicsgui.ThirdPartyGraphicsBasedGUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GraphicsAdapterTest {
    @Test
    void drawHero() {
        ThirdPartyGraphicsBasedGUI gui = Mockito.mock(ThirdPartyGraphicsBasedGUI.class);

        Hero hero = new Hero(new Position(10, 10));
        Screen screen = new GraphicsAdapter(gui);

        screen.drawHero(hero);

        Mockito.verify(gui, Mockito.times(1)).drawHeroSprite(100, 100);
    }
}