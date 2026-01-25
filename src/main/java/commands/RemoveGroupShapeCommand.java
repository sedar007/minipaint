package commands;

import Exceptions.NoShapeSelectedException;
import shapes.CompositeShape;
import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class RemoveGroupShapeCommand implements ICommand {

    private final DrawingPane drawingPane;

    public RemoveGroupShapeCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() throws Exception {
        if(this.drawingPane.getSelection() == null || this.drawingPane.getSelection().isEmpty())
            throw new NoShapeSelectedException();

        List<IShape> deselected = new ArrayList<>();
        for(IShape shape : this.drawingPane.getSelection()) {
            if(shape instanceof CompositeShape){
                List<IShape> childShapes = ((CompositeShape) shape).getShapes();
                deselected.addAll(childShapes);
                this.drawingPane.removeShape(shape);

            }
        }

        for(IShape shape : deselected)
            this.drawingPane.addShape(shape);

    }

    @Override
    public void undo() {

    }
}
