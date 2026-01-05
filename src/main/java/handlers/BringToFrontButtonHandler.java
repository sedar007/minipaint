package handlers;


import commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import shapes.DrawingPane;
import shapes.IShape;


public class BringToFrontButtonHandler implements EventHandler<ActionEvent> {
    private final ICommand command;

    public BringToFrontButtonHandler(ICommand command) {
        this.command = command;
    }

    @Override
    public void handle(ActionEvent event) {
        command.execute();
    }
}
