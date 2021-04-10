import java.util.List;
import java.util.Stack;

public class StringReplacer implements StringTransformer{
    private char a;
    private char b;
    private Stack<String> stack;
    public StringReplacer(char a, char b) {
        this.a = a;
        this.b = b;
        this.stack = new Stack<>();
    }

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        stack.push(text);
        drink.setText(text.replace(a, b));
    }

    public void undo(StringDrink drink) {
        drink.setText(stack.pop());
    }
}
