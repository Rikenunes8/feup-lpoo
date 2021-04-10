import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentMap;

public class IcecreamMachine {

    private Icecream icecream;
    private Stack<Command> commands;

    public IcecreamMachine(Icecream icecream) {
        this.icecream = icecream;
        this.commands = new Stack<>();
    }

    public IcecreamMachine executeCommand(Command command) {
        this.commands.push(command);
        command.execute(this.icecream);
        return this;
    }

    public IcecreamMachine undoLastCommand() {
        this.commands.pop().undo(this.icecream);
        return this;
    }
}
