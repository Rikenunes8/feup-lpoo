import java.util.List;

public abstract class PizzaCertifier {
    protected List<Ingredient> ingredients;

    public abstract boolean isCertified(Pizza pizza);
}
