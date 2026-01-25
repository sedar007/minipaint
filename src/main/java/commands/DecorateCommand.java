package commands;

import Exceptions.NoShapeSelectedException;
import shapes.DecorateShape;
import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class DecorateCommand implements ICommand {

    private final DrawingPane drawingPane;
    private List<IShape> savedShapes;

    public DecorateCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;

    }

    @Override
    public void execute() throws Exception {
        if(drawingPane == null)
            return;
        if(this.drawingPane.getSelection() == null || this.drawingPane.getSelection().isEmpty())
            throw new NoShapeSelectedException();

        savedShapes = new ArrayList<>();
        for(IShape shape : drawingPane)
            this.savedShapes.add(shape);
        try {
            for(IShape shape : drawingPane.getSelection()){
                    IShape decoratedShape = new DecorateShape(shape, "Hello");
                    this.drawingPane.removeShape(shape);
                    this.drawingPane.addShape(decoratedShape);
                }
        }
        catch (Exception e){
            this.drawingPane.clear();
            for(IShape shape : savedShapes)
                this.drawingPane.addShape(shape);
            throw e;
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
