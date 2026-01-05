package handlers;

import commands.AddGroupShapeCommand;
import javafx.event.Event;
import javafx.event.EventHandler;
import shapes.DrawingPane;


public class AddGroupShapeButtonHandler  implements EventHandler<Event> {
    private final DrawingPane drawingPane;

    public AddGroupShapeButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(Event event) {
        this.drawingPane.getCommandHistory().exec(new AddGroupShapeCommand(drawingPane));

    }
}
