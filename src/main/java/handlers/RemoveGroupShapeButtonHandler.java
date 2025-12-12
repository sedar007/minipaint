package handlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import shapes.CompositeShape;
import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;


public class RemoveGroupShapeButtonHandler implements EventHandler<Event> {
    private DrawingPane drawingPane;

    public RemoveGroupShapeButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(Event event) {
        if(this.drawingPane.getSelection().isEmpty()) {
            return;
        }

        List<IShape> deselected = new ArrayList<>();
        for(IShape shape : this.drawingPane.getSelection()) {
            if(shape instanceof CompositeShape){
                List<IShape> childShapes = ((CompositeShape) shape).getShapes();
                deselected.addAll(childShapes);
                this.drawingPane.removeShape(shape);

            }
        }

        for(IShape shape : deselected)
            this.drawingPane.addShape(shape);

    }


}
