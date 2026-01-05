package shapes;

import commands.CommandHistory;
import handlers.MouseMoveHandler;
import handlers.SelectionHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.util.*;

/**
 * Created by lewandowski on 20/12/2020.
 */
public class DrawingPane extends Pane implements Iterable<IShape> {

    private MouseMoveHandler mouseMoveHandler;
    private SelectionHandler selectionHandler;

    public CommandHistory getCommandHistory() {
        return commandHistory;
    }

    private CommandHistory commandHistory;

    private final List<IShape> shapes = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public DrawingPane() {
        clipChildren();
        commandHistory = new CommandHistory();
        mouseMoveHandler = new MouseMoveHandler(this);
        selectionHandler = new SelectionHandler(this);
    }

    public List<IShape> getSelection() {
        if(selectionHandler==null){
            return Collections.emptyList();
        }
        return selectionHandler.getSelectedShapes();
    }

    public void clearSelection() {
        selectionHandler.clearSelectedShapes();
        notifyObservers();
    }


    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        shape.addShapeToPane(this);
        notifyObservers();
    }

    public void removeShape(IShape shape) {
        shapes.remove(shape);
       shape.removeShapeFromPane(this);
        notifyObservers();
    }

    public void clear() {
        for (IShape shape : shapes) {
            shape.removeShapeFromPane(this);
        }
        shapes.clear();
        notifyObservers();
    }

    @Override
    public Iterator<IShape> iterator() {
        return shapes.iterator();
    }

    public Integer shapeCount() {
        return shapes.size();
    }

    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

}
