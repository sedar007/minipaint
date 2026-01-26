package shapes;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class LineStrategy implements  IEdgeStrategy{
    @Override
    public void buildPath(IShape from, IShape to, Path path) {
        path.getElements().clear();
        path.getElements().add(new MoveTo((double)from.centerXProperty().getValue(), (double)from.centerYProperty().getValue()));
        path.getElements().add(new LineTo((double)to.centerXProperty().getValue(), (double)to.centerYProperty().getValue()));
    }
}
