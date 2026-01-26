package commands;

import Exceptions.EdgeSelectedShapeException;
import Exceptions.NoShapeSelectedException;
import shapes.DrawingPane;
import shapes.Edge;
import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class AddEdgeShapeCommand implements ICommand {

    private final DrawingPane drawingPane;
    private Edge edge;


    public AddEdgeShapeCommand(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void execute() throws Exception {


        if(this.drawingPane.getSelection() == null || this.drawingPane.getSelection().isEmpty())
            throw new NoShapeSelectedException();

        if(this.drawingPane.getSelection().size() !=2 )
            throw new EdgeSelectedShapeException();

        IShape from = this.drawingPane.getSelection().get(0);
        IShape to = this.drawingPane.getSelection().get(1);
        edge = new Edge(from, to);
        this.drawingPane.addShape(edge);
    }

    @Override
    public void undo() {
        if(edge == null)
            return;
        this.drawingPane.removeShape(edge);
    }
}
