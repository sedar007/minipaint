package commands;

import shapes.DrawingPane;
import shapes.IShape;

public class MouseMoveCommand  implements ICommand {
    private final DrawingPane drawingPane;
    private final double offsetX;
    private final double offsetY;

    public MouseMoveCommand(DrawingPane drawingPane, double offsetX, double offsetY) {
        this.drawingPane = drawingPane;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    @Override
    public void execute() {
        for(IShape shape : drawingPane.getSelection())
            shape.offset(offsetX, offsetY);
    }

    @Override
    public void undo() {

    }
}
