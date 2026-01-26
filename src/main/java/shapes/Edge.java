package shapes;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Edge implements IShape {
    private IShape from;
    private IShape to;
    private Line shape;
    private Bounds bounds;
    private boolean selected;


    public Edge(IShape from, IShape to) {
        this.from = from;
        this.to = to;
        this.shape = new Line();
        bounds = this.shape.getBoundsInParent();
        this.shape.startXProperty().bind(this.from.centerXProperty());
        this.shape.startYProperty().bind(this.from.centerYProperty());

        this.shape.endXProperty().bind(this.to.centerXProperty());
        this.shape.endYProperty().bind(this.to.centerYProperty());
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
