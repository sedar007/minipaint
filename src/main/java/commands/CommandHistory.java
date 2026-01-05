package commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {

    Deque<ICommand> commandStack;

    public CommandHistory() {
        commandStack = new ArrayDeque<>();
    }

    public void exec(ICommand command){
        commandStack.push(command);
        command.execute();
    }

    public void undo(){
        ICommand command = commandStack.pop();
        command.undo();
    }


}
