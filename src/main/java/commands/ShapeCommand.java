package commands;

import shapes.DrawingPane;
import shapes.IShape;


public class ShapeCommand implements ICommand {

    private final DrawingPane drawingPane;
    protected IShape shape;

    public ShapeCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    public void addShape(IShape shape){
        this.shape =shape;
    }

    @Override
    public void execute() {

        drawingPane.addShape(shape);
    }

    @Override
    public void undo() {

    }

}
