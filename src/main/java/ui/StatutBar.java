package ui;

import shapes.DrawingPane;
import shapes.Observer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class StatutBar extends HBox implements Observer {
    private final Label statusLabel = new Label("");
    private final  Label selectedLabel = new Label("");
    private DrawingPane drawingPane;
    private Integer numberOfShapes = 0;
    private Integer numberOfSelectedShapes = 0;

    public StatutBar() {
        setNbForm(0);
        setNbSelectedForm(0);
        getChildren().add(statusLabel);
        getChildren().add(selectedLabel);
        setPadding(new Insets(4, 8, 4, 8));
        statusLabel.setId("statusLabel");
        selectedLabel.setId("selectedLabel");
        setSpacing(8);
        setMinHeight(24);
        getStyleClass().add("statutBar");
    }

    public void setNbForm(Integer nb) {
        numberOfShapes = nb;
        String message = numberOfShapes + " forme(s)";
        statusLabel.setText(message);
    }

    public void setNbSelectedForm(Integer nb) {
        numberOfSelectedShapes = nb;
        String message = numberOfSelectedShapes + " selected forme(s)";
        selectedLabel.setText(message);
    }

    @Override
    public void update() {
        if (drawingPane == null) return;
        Runnable r = () -> {
            setNbSelectedForm(drawingPane.getSelection().size());
            setNbForm(drawingPane.shapeCount());
        };

        if (Platform.isFxApplicationThread()) {
            r.run();
        } else {
            Platform.runLater(r);
        }
    }

    public void bindTo(DrawingPane pane) {
        if (this.drawingPane != null) {
            this.drawingPane.removeObserver(this);
        }
        this.drawingPane = pane;
        if (this.drawingPane != null) {
            this.drawingPane.addObserver(this);
            update();
        }
    }

}
