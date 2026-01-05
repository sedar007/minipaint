package handlers;

import commands.ICommand;
import commands.MouseMoveCommand;
import shapes.DrawingPane;
import shapes.IShape;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2020.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private Double offsetX = null;
    private Double offsetY = null;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        drawingPane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this);
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
             offsetX = event.getSceneX() - orgSceneX;
             offsetY = event.getSceneY() - orgSceneY;

            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        }

            if(offsetX == null || offsetY == null) return;
            ICommand command = new MouseMoveCommand(drawingPane, offsetX, offsetY);
            command.execute();
    }
}
