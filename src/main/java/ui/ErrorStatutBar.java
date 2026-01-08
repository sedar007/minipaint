package ui;

import commands.CommandHistory;
import commands.ICommand;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import shapes.DrawingPane;
import shapes.Observer;

public class ErrorStatutBar extends HBox implements Observer {
    private final Label statusLabel = new Label("");
    private final  Label selectedLabel = new Label("");
    private CommandHistory commandHistory;

    public ErrorStatutBar() {
        getChildren().add(statusLabel);
        getChildren().add(selectedLabel);
        setPadding(new Insets(4, 8, 4, 8));
        statusLabel.setId("statusLabel");
        selectedLabel.setId("selectedLabel");
        setSpacing(8);
        setMinHeight(24);
        getStyleClass().add("statutBar");
        this.bindTo(commandHistory);

    }

    public void getMessage(String errorMessage) {
        if(commandHistory == null || errorMessage == null || errorMessage.isEmpty()){
            this.setVisible(false);
        }
        this.setVisible(true);
        statusLabel.setText(errorMessage);
    }

    @Override
    public void update() {
        if (commandHistory == null) return;
        Runnable r = () -> {
            getMessage(commandHistory.getErrorMessage());
        };

        if (Platform.isFxApplicationThread()) {
            r.run();
        } else {
            Platform.runLater(r);
        }
    }

    public void bindTo(CommandHistory com) {
        if (this.commandHistory != null) {
            this.commandHistory.removeObserver(this);
        }
        this.commandHistory = com;
        if (this.commandHistory != null) {
            this.commandHistory.addObserver(this);
            update();
        }
    }

}
