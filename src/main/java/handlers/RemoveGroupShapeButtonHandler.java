package handlers;

import commands.ICommand;
import javafx.event.Event;
import javafx.event.EventHandler;
import shapes.CompositeShape;
import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;


public class RemoveGroupShapeButtonHandler implements EventHandler<Event> {
    private final ICommand command;

    public RemoveGroupShapeButtonHandler(ICommand command) {
        this.command = command;
    }

    @Override
    public void handle(Event event) {
        command.execute();
    }


}
