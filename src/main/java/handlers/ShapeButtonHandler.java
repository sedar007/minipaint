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
    protected double originX;
    protected double originY;
    protected double destinationX;
    protected double destinationY;
    protected IShape shape;

    public ShapeButtonHandler(DrawingPane drawingPane)
    {
        this.drawingPane = drawingPane;
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
                shape = createShape();
                ICommand command = new ShapeCommand(drawingPane, shape);
                command.execute();

                drawingPane.removeEventFilter(MouseEvent.MOUSE_PRESSED, this);
                drawingPane.removeEventFilter(MouseEvent.MOUSE_RELEASED, this);
                drawingPane.removeEventFilter(MouseEvent.MOUSE_DRAGGED, this);

            }
        }
    }

    protected abstract IShape createShape();

}
