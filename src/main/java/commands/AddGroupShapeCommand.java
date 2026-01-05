package commands;

import shapes.CompositeShape;
import shapes.DrawingPane;
import shapes.IShape;

public class AddGroupShapeCommand implements ICommand {

    private final DrawingPane drawingPane;

    public AddGroupShapeCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() {
        if(this.drawingPane.getSelection().isEmpty()) {
            return;
        }
        CompositeShape groupShape = new CompositeShape( this.drawingPane.getSelection());
        for(IShape shape : this.drawingPane.getSelection()) {
            this.drawingPane.removeShape(shape);
        }
        this.drawingPane.addShape(groupShape);

    }

    @Override
    public void undo() {

    }

}
