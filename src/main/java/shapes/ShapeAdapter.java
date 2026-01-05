package shapes;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape {
    private Shape shape;
    private boolean selected;


    public ShapeAdapter(Shape shape) {
        this.shape = shape;
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
}
