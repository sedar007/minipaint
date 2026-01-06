package commands;

import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class CloneCommand implements ICommand {

    private final DrawingPane drawingPane;
    private List<IShape> savedShapes;

    public CloneCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;

    }

    @Override
    public void execute() {
        if(drawingPane == null)
            return;

        savedShapes = new ArrayList<>();
        for(IShape shape : drawingPane)
            this.savedShapes.add(shape);

        for(IShape shape : drawingPane.getSelection()){
           IShape s = shape.clone();
           this.drawingPane.addShape(s);

        }
    }

    @Override
    public void undo() {
        if(drawingPane == null || savedShapes == null) return;
        this.drawingPane.clear();

        for(IShape shape : savedShapes)
            this.drawingPane.addShape(shape);
    }
}
