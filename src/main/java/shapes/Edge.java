package shapes;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Edge implements IShape {
    private IShape from;
    private IShape to;
    private Path shape;
    private Bounds bounds;
    private boolean selected;
    private IEdgeStrategy strategy;


    public Edge(IShape from, IShape to, IEdgeStrategy strategy) {
        this.from = from;
        this.to = to;
        this.strategy = strategy;
        this.shape = new Path();
        bounds = this.shape.getBoundsInParent();
        setEdgeStrategy(strategy);

        InvalidationListener updateListener = obs -> this.strategy.buildPath(from, to, shape);
        this.from.centerXProperty().addListener(updateListener);
        this.from.centerYProperty().addListener(updateListener);
        this.to.centerXProperty().addListener(updateListener);
        this.to.centerYProperty().addListener(updateListener);

    }

    public void setEdgeStrategy(IEdgeStrategy strategy) {
        this.strategy = strategy;
        this.strategy.buildPath(from, to, shape);
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
        if(selected){
            this.shape.getStyleClass().add("selected");
        }
        else {
            this.shape.getStyleClass().removeAll("selected");
        }
    }

    @Override
    public boolean isOn(double x, double y) {
        return this.shape.getBoundsInParent().contains(x, y);
    }

    @Override
    public void offset(double x, double y) {

    }

    @Override
    public void addShapeToPane(Pane pane) {
        pane.getChildren().add(this.shape);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        pane.getChildren().remove(this.shape);

    }

    @Override
    public IShape clone() {
        return null;
    }

    @Override
    public ObservableValue centerXProperty() {
        final double x =  bounds.getMinX() + bounds.getWidth() / 2;
        return this.shape.translateXProperty().add(x);
    }

    @Override
    public ObservableValue centerYProperty() {
        final double y = bounds.getMinY() + bounds.getHeight() / 2;
        return this.shape.translateYProperty().add(y);
    }
}
