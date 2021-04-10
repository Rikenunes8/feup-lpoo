public class SlicedPizza implements Pizza {
    private final Pizza pizza;
    private final int slices;

    public SlicedPizza(Pizza pizza, int slices) {
        this.pizza = pizza;
        this.slices = slices;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return this.pizza.addIngredient(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return this.pizza.getIngredientCount();
    }

    @Override
    public boolean contains(Ingredient ingredient) {
        return this.pizza.contains(ingredient);
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice()+2;
    }

    @Override
    public void setPrice(double price) {
        this.pizza.setPrice(price);
    }

    public int getSlices() {
        return this.slices;
    }
}
