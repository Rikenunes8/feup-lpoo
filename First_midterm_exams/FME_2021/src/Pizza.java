public interface Pizza {
    boolean addIngredient(Ingredient ingredient);
    int getIngredientCount();
    boolean contains(Ingredient ingredient);

    double getPrice();

    void setPrice(double v);
}
