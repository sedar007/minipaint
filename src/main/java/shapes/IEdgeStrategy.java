package shapes;

import javafx.scene.shape.Path;

public interface IEdgeStrategy {
    void buildPath(IShape from, IShape to, Path path);
}
