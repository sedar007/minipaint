package handlers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import shapes.DrawingPane;
import shapes.IShape;


public class BringToFrontButtonHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;

    public BringToFrontButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(ActionEvent event) {
        for(IShape shape: drawingPane.getSelection()) {
            drawingPane.removeShape(shape);
            drawingPane.addShape(shape);
        }
        drawingPane.getSelection().clear();
    }
}
