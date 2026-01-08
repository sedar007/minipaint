package commands;

import javafx.scene.control.Alert;
import shapes.Observer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CommandHistory {

    Deque<ICommand> commandStack;
    private String errorMessage;
    private final List<Observer> observers = new ArrayList<>();



    public CommandHistory() {
        commandStack = new ArrayDeque<>();
    }

    public void exec(ICommand command){
        try {
            setErrorMessage(null);
            command.execute();
            commandStack.push(command);
        }
        catch (Exception e){
            setErrorMessage(e.getMessage());
        }
    }

    public void undo(){
        setErrorMessage(null);
        ICommand command = commandStack.pop();
        command.undo();
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }


}
