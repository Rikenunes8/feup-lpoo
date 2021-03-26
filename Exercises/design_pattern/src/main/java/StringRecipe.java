import java.util.ArrayList;
import java.util.List;

public class StringRecipe {
    List<StringTransformer> transformers;
    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers = new ArrayList<>(transformers);
    }


    public void mix(StringDrink drink) {
        for (StringTransformer t:transformers) {
            t.execute(drink);
        }
    }
}
