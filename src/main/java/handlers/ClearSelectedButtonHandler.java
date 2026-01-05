package handlers;

import commands.ICommand;
import shapes.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearSelectedButtonHandler implements EventHandler<ActionEvent> {
    private final ICommand command;

    public ClearSelectedButtonHandler(ICommand command) {
        this.command = command;
    }

    @Override
    public void handle(ActionEvent event) {
        command.execute();
    }

}

