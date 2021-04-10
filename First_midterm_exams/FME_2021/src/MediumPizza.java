import java.util.ArrayList;
import java.util.List;

public class MediumPizza implements Pizza {
    private final List<Ingredient> ingredients;
    private double price;

    public MediumPizza() {
        this.ingredients = new ArrayList<>();
        this.price = 0;
    }
    public boolean addIngredient(Ingredient ingredient) {
        if (this.contains(ingredient)) {
            return false;
        }
        this.ingredients.add(ingredient);
        return true;
    }

    public int getIngredientCount() {
        return this.ingredients.size();
    }

    public boolean contains(Ingredient ingredient) {
        for (Ingredient i:this.ingredients) {
            if (i.getName().equals(ingredient.getName()))
                return true;
        }
        return false;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

}
