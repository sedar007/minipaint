package handlers;

import commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<ActionEvent> {

    private final ICommand command;

    public ClearButtonHandler(ICommand command) {
        this.command = command;
    }

    @Override
    public void handle(ActionEvent event) {
        command.execute();
    }
}
