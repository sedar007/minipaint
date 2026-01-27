package shapes;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape {
    private Shape shape;
    private boolean selected;
    private Bounds b;


    public ShapeAdapter(Shape shape) {
        this.shape = shape;
         b = this.shape.getBoundsInParent();
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
        this.shape.setTranslateX(this.shape.getTranslateX() + x);
        this.shape.setTranslateY(this.shape.getTranslateY() + y);
    }

    @Override
    public void addShapeToPane(javafx.scene.layout.Pane pane) {
        pane.getChildren().add(shape);
    }

    @Override
    public void removeShapeFromPane(javafx.scene.layout.Pane pane) {
        pane.getChildren().remove(shape);
    }

    @Override
    public IShape clone() {
        Shape clonedShape = Shape.union(shape, shape);
        clonedShape.getStyleClass().addAll(shape.getStyleClass());
        return new ShapeAdapter(clonedShape);
    }

    @Override
    public ObservableValue centerXProperty() {
        final double x =  b.getMinX() + b.getWidth() / 2;
       return this.shape.translateXProperty().add(x);
    }

    @Override
    public ObservableValue centerYProperty() {
        final double y = b.getMinY() + b.getHeight() / 2;
        return this.shape.translateYProperty().add(y);
    }
}
