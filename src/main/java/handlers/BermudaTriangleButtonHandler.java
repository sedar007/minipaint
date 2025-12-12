package handlers;

import shapes.DrawingPane;
import shapes.IShape;
import shapes.ShapeAdapter;
import javafx.scene.shape.Polygon;

public class BermudaTriangleButtonHandler extends ShapeButtonHandler {

    public BermudaTriangleButtonHandler(DrawingPane drawingPane) {
        super(drawingPane);
    }

    @Override
    protected IShape createShape() {
        double minX = Math.min(originX, destinationX);
        double maxX = Math.max(originX, destinationX);
        double minY = Math.min(originY, destinationY);
        double maxY = Math.max(originY, destinationY);

        double cx = (minX + maxX) / 2.0;

        Polygon triangle = new Polygon(
                minX, maxY,
                maxX, maxY,
                cx,  minY
        );
        triangle.getStyleClass().add("bermuda-triangle");
        return new ShapeAdapter(triangle);
    }
}
