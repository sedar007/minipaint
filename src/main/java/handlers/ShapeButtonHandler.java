package handlers;

import commands.ICommand;
import commands.ShapeCommand;
import shapes.DrawingPane;
import shapes.IShape;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2020.
 */
public abstract class ShapeButtonHandler implements EventHandler<Event> {

    private DrawingPane drawingPane;
    private final ShapeCommand command;
    protected double originX;
    protected double originY;
    protected double destinationX;
    protected double destinationY;

    public ShapeButtonHandler(DrawingPane drawingPane, ShapeCommand command)
    {
        this.drawingPane = drawingPane;
        this.command = command;
    }

    @Override
    public void handle(Event event) {

        if (event instanceof ActionEvent) {
            drawingPane.addEventFilter(MouseEvent.MOUSE_PRESSED, this);
        }

        if (event instanceof MouseEvent) {
            if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                drawingPane.addEventFilter(MouseEvent.MOUSE_RELEASED, this);
                drawingPane.addEventFilter(MouseEvent.MOUSE_DRAGGED, this);
                originX = ((MouseEvent) event).getX();
                originY = ((MouseEvent) event).getY();
                event.consume();
            }

            if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                destinationX = ((MouseEvent) event).getX();
                destinationY = ((MouseEvent) event).getY();

                command.addShape(createShape());
                command.execute();

                drawingPane.removeEventFilter(MouseEvent.MOUSE_PRESSED, this);
                drawingPane.removeEventFilter(MouseEvent.MOUSE_RELEASED, this);
                drawingPane.removeEventFilter(MouseEvent.MOUSE_DRAGGED, this);

            }
        }
    }

    protected abstract IShape createShape();

}
