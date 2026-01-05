package commands;

import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class ClearCommand  implements ICommand {

    private final DrawingPane drawingPane;
    private List<IShape> savedShapes;

    public ClearCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        savedShapes = new ArrayList<>();
    }

    @Override
    public void execute() {
        if(drawingPane == null)
            return;
        this.savedShapes.clear();
        for(IShape shape : drawingPane)
            this.savedShapes.add(shape);

        this.drawingPane.clear();
    }

    @Override
    public void undo() {
        if(drawingPane == null || savedShapes == null) return;
        this.drawingPane.clear();

        for(IShape shape : savedShapes)
            this.drawingPane.addShape(shape);
    }
}
