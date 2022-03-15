package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMenu {

    private double WIDTH = 800;
    private double HEIGHT = 800;
    private Scene scene;

    public AdminMenu(Stage stage){

        String[] buttonNames = new String[]{"registerPlayer","registerTournament","currentTournament",
                                            "editPlayer","editTournament","statistics"};

        String[] buttonLabels = new String[]{"Register Player", "Register Tournament", "Current Tournament",
                                             "Edit Player","Edit Tournament","Statistics"};

        Button[] buttons = new Button[buttonNames.length];

        for(var i=0;i<buttonNames.length;i++){
            buttons[i] = new Button(buttonLabels[i]);
            int sceneNumber = i;
            buttons[i].setOnAction(e ->{
                SceneController sceneController = new SceneController(stage);
                sceneController.switchScene(sceneNumber);
            });
        }

        Label title = new Label("Administration");

        /**
        Button registerPlayer = new Button("Register Player");
        Button registerTournament = new Button("Register Tournament");
        Button currentTournament = new Button("Current Tournament");

        Button editPlayer = new Button("Edit Player");
        Button editTournament = new Button("Edit Tournament");
        Button statistics = new Button("Statistics");
        */

        VBox leftColumn = new VBox(buttons[0],buttons[1],buttons[2]);
        leftColumn.getStyleClass().add("vbox");

        VBox rightColumn = new VBox(buttons[3],buttons[4],buttons[5]);
        rightColumn.getStyleClass().add("vbox");

        HBox hbox = new HBox(leftColumn,rightColumn);
        hbox.setAlignment(Pos.CENTER);
        hbox.getStyleClass().add("hbox");

        VBox layout = new VBox(title,hbox);
        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("layout");

        scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("AdminMenu.css").toExternalForm());
    }


    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public Scene getScene() {
        return scene;
    }

    public void setWIDTH(double WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(double HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
}
