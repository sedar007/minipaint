package shapes;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Edge implements IShape {
    private IShape from;
    private IShape to;
    private Line shape;

    public Edge(IShape from, IShape to) {
        this.from = from;
        this.to = to;
        this.shape = new Line();
        this.shape.startXProperty().bind(this.from.centerXProperty());
        this.shape.startYProperty().bind(this.from.centerYProperty());

        this.shape.endXProperty().bind(this.to.centerXProperty());
        this.shape.endYProperty().bind(this.to.centerYProperty());
    }

    @Override
    public boolean isSelected() {
        return this.from.isSelected() && this.to.isSelected();
    }

    @Override
    public void setSelected(boolean selected) {
        if(selected){
            this.from.setSelected(true);
            this.to.setSelected(false);
        }
    }

    @Override
    public boolean isOn(double x, double y) {
        return this.from.isOn(x, y) && this.to.isOn(x, y);
    }

    @Override
    public void offset(double x, double y) {
        this.from.offset(x, y);
        this.to.offset(x, y);
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
        return null;
    }

    @Override
    public ObservableValue centerYProperty() {
        return null;
    }
}
