package shapes;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class DecorateShape  implements IShape{
    private IShape shape;
    private Shape decoratedShape;
    private String text;

    public DecorateShape(IShape shape, String text) throws Exception {
        if(shape instanceof CompositeShape) throw new Exception("Impossible to create a decorate shape with composite shape.");
        this.shape = shape;
        this.text = text;
        this.decoratedShape= new Text(text);
        this.decoratedShape.getStyleClass().add("decorated-shape");
    }


    @Override
    public boolean isSelected() {
        return this.shape.isSelected();
    }

    @Override
    public void setSelected(boolean selected) {
        this.shape.setSelected(selected);
    }

    @Override
    public boolean isOn(double x, double y) {
        return this.shape.isOn(x, y);
    }

    @Override
    public void offset(double x, double y) {
        this.shape.offset(x,y);
        this.decoratedShape.setTranslateX(this.decoratedShape.getTranslateX() + x);
        this.decoratedShape.setTranslateY(this.decoratedShape.getTranslateY() + y);

    }

    @Override
    public void addShapeToPane(Pane pane) {
        this.shape.addShapeToPane(pane);
        pane.getChildren().add(this.decoratedShape);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        this.shape.removeShapeFromPane(pane);
        pane.getChildren().remove(this.decoratedShape);
    }

    @Override
    public IShape clone() {
        try {
            return new DecorateShape(this.shape.clone(), text);
        } catch (Exception e) {
         throw new RuntimeException(e);
        }
    }
}
