package handlers;

import commands.AddEdgeShapeCommand;
import commands.AddPathShapeCommand;
import javafx.event.Event;
import javafx.event.EventHandler;
import shapes.DrawingPane;
import shapes.IEdgeStrategy;

public class AddPathShapeButtonHandle implements EventHandler<Event> {
    private final DrawingPane drawingPane;
    private final IEdgeStrategy strategy;
    public AddPathShapeButtonHandle(DrawingPane drawingPane, IEdgeStrategy strategy) {
        this.drawingPane = drawingPane;
        this.strategy = strategy;
    }

    @Override
    public void handle(Event event) {
        this.drawingPane.getCommandHistory().exec(new AddPathShapeCommand(drawingPane, this.strategy));

    }
}
