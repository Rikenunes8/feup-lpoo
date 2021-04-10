import java.util.ArrayList;
import java.util.List;

public class MargueritaCertifier extends PizzaCertifier{

    public MargueritaCertifier() {
        super();
        this.ingredients = new ArrayList<>();
        this.ingredients.add(new Ingredient("Tomato"));
        this.ingredients.add(new Ingredient("Mozzarella"));
        this.ingredients.add(new Ingredient("Basil"));
    }

    @Override
    public boolean isCertified(Pizza pizza) {
        if (pizza.getIngredientCount() != ingredients.size())
            return false;
        for (Ingredient i:this.ingredients) {
            if (!pizza.contains(i))
                return false;
        }
        return true;
    }
}
