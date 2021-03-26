import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBarTest {
    @Test
    public void happyHour() {
        Bar bar = new StringBar();
        assertFalse(bar.isHappyHour());

        bar.startHappyHour();
        assertTrue(bar.isHappyHour());

        bar.endHappyHour();
        assertFalse(bar.isHappyHour());
    }


    @Test
    public void orderStringRecipe() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = Util.getRecipe();

        stringBar.order(drink, recipe);
        assertEquals("dCbX-DcBa", drink.getText());
    }
}