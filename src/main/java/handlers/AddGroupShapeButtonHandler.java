package handlers;

import commands.ICommand;
import javafx.event.Event;
import javafx.event.EventHandler;



public class AddGroupShapeButtonHandler  implements EventHandler<Event> {
    private final ICommand command;

    public AddGroupShapeButtonHandler(ICommand command) {
        this.command = command;
    }

    @Override
    public void handle(Event event) {
        command.execute();
    }
}
