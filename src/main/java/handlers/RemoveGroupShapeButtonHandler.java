package handlers;

import commands.ICommand;
import commands.RemoveGroupShapeCommand;
import javafx.event.Event;
import javafx.event.EventHandler;
import shapes.CompositeShape;
import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;


public class RemoveGroupShapeButtonHandler implements EventHandler<Event> {
    private final DrawingPane drawingPane;

    public RemoveGroupShapeButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(Event event) {
        this.drawingPane.getCommandHistory().exec(new RemoveGroupShapeCommand(drawingPane));
    }


}
