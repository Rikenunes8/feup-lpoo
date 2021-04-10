import java.util.ArrayDeque;
import java.util.Stack;

public class StringInverter implements StringTransformer{

    private Stack<String> stack = new Stack<>();

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        stack.push(text);
        StringBuffer sbr = new StringBuffer(text);
        sbr.reverse();
        drink.setText(sbr.toString());
    }
    public void undo(StringDrink drink) {
        drink.setText(stack.pop());
    }
}
