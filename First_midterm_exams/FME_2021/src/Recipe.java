import java.util.List;

public abstract class Recipe {
    protected List<Ingredient> ingredients;

    public Pizza makeMediumPizza() {
        Pizza pizza = new MediumPizza();
        for (Ingredient i : this.ingredients) {
            pizza.addIngredient(i);
        }
        return pizza;
    }
}
