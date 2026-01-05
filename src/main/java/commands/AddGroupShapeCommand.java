package commands;

import shapes.CompositeShape;
import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class AddGroupShapeCommand implements ICommand {

    private final DrawingPane drawingPane;
    private CompositeShape groupShape;
    private List<IShape> originalShapes;


    public AddGroupShapeCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() {
        if(drawingPane == null || this.drawingPane.getSelection().isEmpty()) {
            return;
        }

        this.originalShapes = new ArrayList<>(this.drawingPane.getSelection());
        this.groupShape = new CompositeShape(this.originalShapes);


        for (IShape shape : this.originalShapes) {
            this.drawingPane.removeShape(shape);
        }

        this.drawingPane.addShape(this.groupShape);
    }

    @Override
    public void undo() {
        if (this.groupShape == null || this.originalShapes == null) {
            return;
        }
        this.drawingPane.removeShape(this.groupShape);
        for (IShape shape : this.originalShapes) {
            this.drawingPane.addShape(shape);
        }
    }

}
