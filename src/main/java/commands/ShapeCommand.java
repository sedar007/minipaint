package commands;

import shapes.DrawingPane;
import shapes.IShape;


public class ShapeCommand implements ICommand {

    private final DrawingPane drawingPane;
    protected IShape shape;

    public ShapeCommand(DrawingPane drawingPane, IShape shape) {
        this.drawingPane = drawingPane;
        this.shape = shape;
    }

    @Override
    public void execute() {
        drawingPane.addShape(shape);
    }

    @Override
    public void undo() {

    }

}
