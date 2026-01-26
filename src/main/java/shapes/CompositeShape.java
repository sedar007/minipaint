package shapes;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements IShape {
    private List<IShape> shapes = new ArrayList<>();
    private boolean selected;


    public CompositeShape( List<IShape> shapesList) {
        shapes.addAll(shapesList);
    }

    public List<IShape> getShapes() {
        return shapes;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelected(boolean selected) {
        for(IShape shape : shapes){
            shape.setSelected(selected);
        }
        this.selected = selected;
    }

    @Override
    public boolean isOn(double x, double y) {
        for(IShape shape : shapes)
            if(shape.isOn(x, y))
                return true;
        return false;
    }

    @Override
    public void offset(double x, double y) {
        for(IShape shape : shapes)
            shape.offset(x, y);
    }

    @Override
    public void addShapeToPane(Pane pane) {
        for (IShape shape: shapes)
            shape.addShapeToPane(pane);
    }

    @Override
    public void removeShapeFromPane(javafx.scene.layout.Pane pane) {
        for (IShape shape: shapes)
            shape.removeShapeFromPane(pane);

    }

    @Override
    public IShape clone() {
        List<IShape> shapeList = new ArrayList<>();
        for(IShape shape : shapes)
            shapeList.add(shape.clone());
        return new CompositeShape(shapeList);
    }

    @Override
    public ObservableValue centerXProperty() {
        return null;
    }

    @Override
    public ObservableValue centerYProperty() {
        return null;
    }


}
