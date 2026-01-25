package commands;

import Exceptions.NoShapeSelectedException;
import shapes.DrawingPane;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class ClearSelectedCommad implements ICommand {

    private final DrawingPane drawingPane;
    private List<IShape> selectedShapes;

    public ClearSelectedCommad(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() throws Exception {
        if(this.drawingPane.getSelection() == null || this.drawingPane.getSelection().isEmpty())
            throw new NoShapeSelectedException();
        selectedShapes = new ArrayList<>(this.drawingPane.getSelection());
        this.drawingPane.clearSelection();
    }

    @Override
    public void undo() {
        if(drawingPane == null || selectedShapes == null) return;

        for(IShape shape : selectedShapes)
            this.drawingPane.addShape(shape);
    }
}
