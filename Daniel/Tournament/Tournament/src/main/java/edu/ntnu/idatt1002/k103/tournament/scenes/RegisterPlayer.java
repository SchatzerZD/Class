package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class RegisterPlayer {
    private double WIDTH = 800;
    private double HEIGHT = 800;
    private Scene scene;

    public RegisterPlayer(Stage stage){

        Label title = new Label("Register Player");
        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");
        Label email = new Label("Email");

        TextField firstNameInput = new TextField();
        TextField lastNameInput = new TextField();
        TextField emailInput = new TextField();

        MenuButton teamsDropDown = new MenuButton("Teams");

        Button returnButton = new Button("X");
        Button register = new Button("Register");

        Pane topScreenSpacer = new Pane();
        Pane layoutSpacer = new Pane();

        VBox firstNameBox = new VBox(firstName,firstNameInput);
        VBox lastNameBox = new VBox(lastName,lastNameInput);
        VBox emailBox = new VBox(email,emailInput);
        HBox topScreen = new HBox(title,topScreenSpacer,returnButton);

        GridPane layout = new GridPane();
        layout.add(topScreen,0,0,2,1);
        layout.add(layoutSpacer,0,1,1,1);
        layout.add(firstNameBox,0,2,1,1);
        layout.add(emailBox,0,3,2,1);
        layout.add(teamsDropDown,0,4,1,2);
        layout.add(lastNameBox,1,2,1,1);
        layout.add(register,1,5,1,1);

        layout.setId("layout");
        topScreen.setId("topScreen");
        returnButton.setId("returnButton");
        layoutSpacer.setId("layoutSpacer");

        returnButton.setOnAction(e ->{
            SceneController sceneController = new SceneController(stage);
            sceneController.switchScene(9);
        });

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
