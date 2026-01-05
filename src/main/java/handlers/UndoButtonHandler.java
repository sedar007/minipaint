package handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import shapes.DrawingPane;

public class UndoButtonHandler implements EventHandler<ActionEvent> {
    private final DrawingPane drawingPane;

    public UndoButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(ActionEvent event) {
        this.drawingPane.getCommandHistory().undo();
    }
}

