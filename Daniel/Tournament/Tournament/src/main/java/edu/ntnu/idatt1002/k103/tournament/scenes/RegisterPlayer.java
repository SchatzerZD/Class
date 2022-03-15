package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class RegisterPlayer {
    private double WIDTH = 800;
    private double HEIGHT = 800;
    private Scene scene;

    public RegisterPlayer(Stage stage){

        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");
        Label emailName = new Label("Email");

        firstName.getStyleClass().add("inputLabels");
        lastName.getStyleClass().add("inputLabels");
        emailName.getStyleClass().add("inputLabels");

        TextField firstNameInput = new TextField();
        TextField lastNameInput = new TextField();

        VBox firstNameVbox = new VBox(firstName,firstNameInput);
        VBox lastNameVbox = new VBox(lastName,lastNameInput);

        HBox firstColumns = new HBox(firstNameVbox,lastNameVbox);
        firstColumns.getStyleClass().add("hbox");

        TextField emailInput = new TextField();
        emailInput.setMaxWidth(500);

        VBox emailBox = new VBox(emailName,emailInput);

        MenuButton teamDropDown = new MenuButton("Teams");
        Button registerButton = new Button("Register");

        HBox secondColumns = new HBox(teamDropDown,registerButton);
        secondColumns.getStyleClass().add("hbox");

        Button returnButton = new Button("X");
        returnButton.setId("returnButton");

        returnButton.setOnAction(e ->{
            SceneController sceneController = new SceneController(stage);
            sceneController.switchScene(9);
        });

        Label screenTitle = new Label("Register Player");
        screenTitle.setId("title");

        HBox topScreen = new HBox(screenTitle,returnButton);
        topScreen.setId("topScreen");

        VBox vbox = new VBox(firstColumns,emailBox,secondColumns);
        vbox.setId("vbox");
        vbox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(topScreen,vbox);
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("RegisterPlayer.css").toExternalForm());
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
