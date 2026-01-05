package handlers;

import commands.ClearSelectedCommad;
import shapes.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearSelectedButtonHandler implements EventHandler<ActionEvent> {
    private final DrawingPane drawingPane;

    public ClearSelectedButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(ActionEvent event) {
       this.drawingPane.getCommandHistory().exec(new ClearSelectedCommad(drawingPane));
    }

}

