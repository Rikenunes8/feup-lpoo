import java.util.ArrayDeque;
import java.util.Stack;

public class StringCaseChanger implements StringTransformer{
    private Stack<String> stack = new Stack<>();;

    @Override
    public void execute(StringDrink drink) {
        StringBuilder sb = new StringBuilder();
        String text = drink.getText();
        stack.push(text);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            else {
                c = Character.toLowerCase(c);
            }
            sb.append(c);
        }
        drink.setText(sb.toString());
    }

    public void undo(StringDrink drink) {
        drink.setText(stack.pop());
    }
}
