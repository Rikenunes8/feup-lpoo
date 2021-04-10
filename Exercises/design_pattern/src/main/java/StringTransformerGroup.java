import java.util.ArrayList;
import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = new ArrayList<>(transformers);


    }

    @Override
    public void execute(StringDrink drink) {
        for (StringTransformer t:transformers) {
            t.execute(drink);
        }
    }
}
