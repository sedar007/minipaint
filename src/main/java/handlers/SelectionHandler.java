package handlers;

import shapes.DrawingPane;
import shapes.IShape;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class SelectionHandler   implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;
    private final List<IShape> selectedShapes = new ArrayList<>();

    public SelectionHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
    }

    public List<IShape> getSelectedShapes() {
        return selectedShapes;
    }

    public void clearSelectedShapes() {
        for(IShape shape : selectedShapes) {
            shape.setSelected(false);
            drawingPane.removeShape(shape);
        }
        selectedShapes.clear();
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {

            IShape clickedShape = null;
            for (IShape shape : drawingPane) {
                if (shape.isOn(event.getX(), event.getY())) {
                    clickedShape = shape;
                    break;
                }
            }

            if (clickedShape == null) {
                clearSelection();
                return;
            }

            if(selectedShapes.contains(clickedShape) && !event.isShiftDown()){
                return;
            }

            if (event.isShiftDown()) {

                if (clickedShape.isSelected()) {
                    clickedShape.setSelected(false);
                    selectedShapes.remove(clickedShape);
                }
                else {
                    clickedShape.setSelected(true);
                    selectedShapes.add(clickedShape);
                }
            }
            else {
                clearSelection();
                clickedShape.setSelected(true);
                selectedShapes.add(clickedShape);
            }
            drawingPane.notifyObservers();
        }
    }
    private void clearSelection() {
        for (IShape s : drawingPane) {
            s.setSelected(false);
        }
        selectedShapes.clear();
        drawingPane.notifyObservers();
    }
}
