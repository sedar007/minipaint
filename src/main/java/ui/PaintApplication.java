package ui;

import javafx.scene.layout.VBox;
import shapes.DrawingPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by lewandowski on 20/12/2020.
 */
public class PaintApplication extends Application {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Scene scene;
    private BorderPane root;
    private DrawingPane drawingPane;



    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        scene = new Scene(root, WIDTH, HEIGHT);

        root.getStylesheets().add(
                PaintApplication.class.getClassLoader().getResource("style/Paint.css").toExternalForm());

        drawingPane = new DrawingPane();
        drawingPane.getStyleClass().add("drawingPane");
        root.setCenter(drawingPane);

        HBox hBox = new HBox();
        ToolBar toolBar = new ToolBar(drawingPane, hBox);
        hBox.setPadding(new Insets(5));
        hBox.setSpacing(5.0);

        StatutBar statutBar = new StatutBar();
        statutBar.bindTo(drawingPane);

        ErrorStatutBar errorStatutBar = new ErrorStatutBar();
        errorStatutBar.bindTo(drawingPane.getCommandHistory());
        VBox vBox = new VBox(statutBar, errorStatutBar);

        root.setBottom(vBox);
        root.setTop(hBox);

        primaryStage.setTitle("Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public DrawingPane getDrawingPane() {
        return drawingPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
