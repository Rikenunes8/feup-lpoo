import java.util.ArrayList;
import java.util.List;

public class MargueritaRecipe extends Recipe {

    public MargueritaRecipe() {
        super();
        this.ingredients = new ArrayList<>();
        this.ingredients.add(new Ingredient("Tomato"));
        this.ingredients.add(new Ingredient("Mozzarella"));
        this.ingredients.add(new Ingredient("Basil"));
    }
}
