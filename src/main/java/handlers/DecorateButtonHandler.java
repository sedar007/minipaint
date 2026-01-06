package handlers;

import commands.DecorateCommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import shapes.DrawingPane;

public class DecorateButtonHandler implements EventHandler<ActionEvent> {

    private final DrawingPane drawingPane;

    public DecorateButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(ActionEvent event) {
        this.drawingPane.getCommandHistory().exec(new DecorateCommand(drawingPane));
    }
}
