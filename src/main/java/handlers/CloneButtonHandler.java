package handlers;

import commands.CloneCommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import shapes.DrawingPane;

public class CloneButtonHandler implements EventHandler<ActionEvent> {

    private final DrawingPane drawingPane;

    public CloneButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(ActionEvent event) {
        this.drawingPane.getCommandHistory().exec(new CloneCommand(drawingPane));
    }
}
