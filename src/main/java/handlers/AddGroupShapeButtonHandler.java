package handlers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import shapes.CompositeShape;
import shapes.DrawingPane;
import shapes.IShape;



public class AddGroupShapeButtonHandler  implements EventHandler<Event> {
    private DrawingPane drawingPane;

    public AddGroupShapeButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(Event event) {
        if(this.drawingPane.getSelection().isEmpty()) {
            return;
        }

        CompositeShape groupShape = new CompositeShape( this.drawingPane.getSelection());

        for(IShape shape : this.drawingPane.getSelection()) {
            this.drawingPane.removeShape(shape);
        }
       this.drawingPane.addShape(groupShape);


    }


}
