package commands;

import shapes.DrawingPane;
import shapes.IShape;

import java.util.List;

public class ClearSelectedCommad implements ICommand {

    private final DrawingPane drawingPane;

    public ClearSelectedCommad(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() {
        this.drawingPane.clearSelection();
    }

    @Override
    public void undo() {

    }
}
