package handlers;

import commands.AddEdgeShapeCommand;
import javafx.event.Event;
import javafx.event.EventHandler;
import shapes.DrawingPane;

public class AddEdgeShapeButtonHandle  implements EventHandler<Event> {
    private final DrawingPane drawingPane;
    public AddEdgeShapeButtonHandle(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(Event event) {
        this.drawingPane.getCommandHistory().exec(new AddEdgeShapeCommand(drawingPane));

    }
}
