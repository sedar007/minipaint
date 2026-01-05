package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Objects;

public class ButtonFactory {

    public static final String ICONS_ONLY = "ICONS_ONLY";
    public static final String TEXT_ONLY = "TEXT_ONLY";

    public static final String CLEAR_ALL = "CLEAR_ALL";
    public static final String CLEAR_SELECTED = "CLEAR_SELECTED";
    public static final String RECTANGLE = "RECTANGLE";
    public static final String CIRCLE = "CIRCLE";
    public static final String TRIANGLE = "TRIANGLE";
    public  static final String ADD_GROUP_SHAPE = "ADD_GROUP_SHAPE";
    public static final  String REMOVE_GROUP_SHAPE="REMOVE_GROUP_SHAPE";
    public static final String TOFRONT = "Front";

    private static final String IMAGE_PATH = "/images/";
    private static final String CLEAR_ALL_FILE = "clear_all.png";
    private static final String CLEAR_SELECTED_FILE = "clear.png";
    private static final String RECTANGLE_FILE = "rectangle.png";
    private static final String CIRCLE_FILE = "circle.png";
    private static final String TRIANGLE_FILE = "triangle.png";
    private static final String ADD_GROUP_SHAPE_FILE = "group.png";
    private static final String REMOVE_GROUP_SHAPE_FILE="ungroup.png";
    private static final String TOFRONT_FILE="ungroup.png";



    private final String style;

    public ButtonFactory() {
        this(ICONS_ONLY);
    }

    public ButtonFactory(String style) {
        Objects.requireNonNull(style, "style must not be null");
        if (!style.equals(ICONS_ONLY) && !style.equals(TEXT_ONLY)) {
            throw new IllegalArgumentException("Unknown style: " + style);
        }
        this.style = style;
    }

    public Button createButton(String buttonName) {
        Objects.requireNonNull(buttonName, "buttonName must not be null");
        String imageFile;
        String tooltipText;
        String id;

        switch (buttonName) {
            case CLEAR_ALL:
                imageFile = CLEAR_ALL_FILE;
                tooltipText = "Clear";
                id = "clearAllButton";
                break;
            case CLEAR_SELECTED:
                imageFile = CLEAR_SELECTED_FILE;
                tooltipText = "Clear Selected";
                id = "clearSelectedButton";
                break;
            case RECTANGLE:
                imageFile = RECTANGLE_FILE;
                tooltipText = "Rectangle";
                id = "rectangleButton";
                break;
            case CIRCLE:
                imageFile = CIRCLE_FILE;
                tooltipText = "Circle";
                id = "circleButton";
                break;
            case TRIANGLE:
                imageFile = TRIANGLE_FILE;
                tooltipText = "Bermuda Triangle";
                id = "triangleButton";
                break;
            case ADD_GROUP_SHAPE:
                imageFile = ADD_GROUP_SHAPE_FILE;
                tooltipText = "Add Group Shape";
                id = "addGroupShapeButton";
                break;
            case REMOVE_GROUP_SHAPE:
                imageFile = REMOVE_GROUP_SHAPE_FILE;
                tooltipText = "Remove Group Shape";
                id = "removeGroupShapeButton";
                break;
            case TOFRONT:
                imageFile = TOFRONT_FILE;
                tooltipText = "Tofront Shape";
                id = "toFrontButton";
                break;
            default:
                throw new IllegalArgumentException("Unknown button name: " + buttonName);
        }

        Button button = new Button();
        button.setId(id);
        button.setTooltip(new Tooltip(tooltipText));

        if (ICONS_ONLY.equals(style)) {
            InputStream stream = getClass().getResourceAsStream(IMAGE_PATH + imageFile);
            if (stream == null) {
                throw new IllegalArgumentException("Image resource not found: " + IMAGE_PATH + imageFile);
            }
            button.setGraphic(new ImageView(new Image(stream)));
        }
        else {
            button.setText(tooltipText);
        }

        return button;
    }
}
