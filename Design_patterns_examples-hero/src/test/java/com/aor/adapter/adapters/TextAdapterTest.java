package com.aor.adapter.adapters;

import com.aor.adapter.Hero;
import com.aor.adapter.Position;
import com.aor.adapter.Screen;
import com.aor.adapter.textgui.ThirdPartyTextBasedGUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TextAdapterTest {

    @Test
    void drawHero() {
        ThirdPartyTextBasedGUI gui = Mockito.mock(ThirdPartyTextBasedGUI.class);

        Hero hero = new Hero(new Position(10, 10));
        Screen screen = new TextAdapter(gui);

        screen.drawHero(hero);

        Mockito.verify(gui, Mockito.times(1)).changeBackgroundColor("blue");
        Mockito.verify(gui, Mockito.times(1)).drawCharacter('H', 10, 10);
    }
}