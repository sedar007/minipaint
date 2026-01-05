package commands;

import shapes.DrawingPane;
import shapes.IShape;

import java.util.LinkedHashMap;
import java.util.Map;

public class BringToFrontCommand implements ICommand {

    private final DrawingPane drawingPane;
    private final Map<IShape, Integer> oldIndices = new LinkedHashMap<>();

    public BringToFrontCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() {

        for(IShape shape: drawingPane.getSelection()) {
            drawingPane.removeShape(shape);
            drawingPane.addShape(shape);
        }
        drawingPane.getSelection().clear();
    }

    @Override
    public void undo() {

    }
}
