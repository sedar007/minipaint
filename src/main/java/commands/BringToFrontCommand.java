package commands;

import shapes.DrawingPane;
import shapes.IShape;

public class BringToFrontCommand implements ICommand {

    private final DrawingPane drawingPane;

    public BringToFrontCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() {
        for(IShape shape: drawingPane.getSelection()) {
            drawingPane.removeShape(shape);
            drawingPane.addShape(shape);
        }
        drawingPane.getSelection().clear();
    }

    @Override
    public void undo() {

    }
}
