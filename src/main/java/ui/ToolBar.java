package ui;

import commands.ClearCommand;
import commands.ICommand;
import javafx.event.EventHandler;
import shapes.DrawingPane;
import handlers.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Tooltip;

public class ToolBar {

    private Button clearButton;
    private Button clearSelectedButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button bermudaTriangleButton;
    private Button groupeButton;
    private Button removeGroupButton;
    private Button toFrontButton;


    private final ButtonFactory buttonFactory = new ButtonFactory();
    private final ButtonFactory buttonFactory2 = new ButtonFactory(ButtonFactory.TEXT_ONLY);



    public ToolBar(DrawingPane drawingPane, HBox hBox) {
        clearButton = buttonFactory.createButton(ButtonFactory.CLEAR_ALL);
        ICommand clearCommand = new ClearCommand(drawingPane);
        clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(clearCommand));


        clearSelectedButton = buttonFactory.createButton(ButtonFactory.CLEAR_SELECTED);
        clearSelectedButton.addEventFilter(ActionEvent.ACTION, new ClearSelectedButtonHandler(drawingPane));

        rectangleButton = buttonFactory.createButton(ButtonFactory.RECTANGLE);
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));

        circleButton = buttonFactory.createButton(ButtonFactory.CIRCLE);
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));

        bermudaTriangleButton = buttonFactory2.createButton(ButtonFactory.TRIANGLE);
        bermudaTriangleButton.addEventFilter(ActionEvent.ACTION, new BermudaTriangleButtonHandler(drawingPane));

        groupeButton = buttonFactory2.createButton(ButtonFactory.ADD_GROUP_SHAPE);
        groupeButton.addEventFilter(ActionEvent.ACTION, new AddGroupShapeButtonHandler(drawingPane));

        removeGroupButton = buttonFactory2.createButton(ButtonFactory.REMOVE_GROUP_SHAPE);
        removeGroupButton.addEventFilter(ActionEvent.ACTION, new RemoveGroupShapeButtonHandler(drawingPane));

        toFrontButton = buttonFactory2.createButton(ButtonFactory.TOFRONT);
        toFrontButton.addEventFilter(ActionEvent.ACTION, new BringToFrontButtonHandler(drawingPane));

        hBox.getChildren().addAll(clearButton, clearSelectedButton, rectangleButton, circleButton, bermudaTriangleButton, groupeButton, removeGroupButton, toFrontButton);
        hBox.getStyleClass().add("toolbar");
    }


}
