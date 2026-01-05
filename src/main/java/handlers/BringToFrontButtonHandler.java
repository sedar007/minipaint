package handlers;


import commands.BringToFrontCommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import shapes.DrawingPane;


public class BringToFrontButtonHandler implements EventHandler<ActionEvent> {
    private final DrawingPane drawingPane;

    public BringToFrontButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(ActionEvent event) {
        this.drawingPane.getCommandHistory().exec(new BringToFrontCommand(drawingPane));

    }
}
