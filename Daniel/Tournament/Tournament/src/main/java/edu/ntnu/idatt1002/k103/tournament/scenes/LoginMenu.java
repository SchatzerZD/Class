package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class LoginMenu {

    private double WIDTH = 800;
    private double HEIGHT = 800;
    private Scene scene;

    public LoginMenu(){

        Label epost = new Label();
        epost.setText("E-post");
        epost.setAlignment(Pos.CENTER_LEFT);

        TextField epostInput = new TextField();
        epostInput.setMinWidth(500);

        Group epostGroup = new Group(new VBox(epost,epostInput));

        Label password = new Label();
        password.setText("Passord");

        TextField passwordInput = new TextField();
        passwordInput.setMinWidth(500);

        Group passwordGroup = new Group(new VBox(password,passwordInput));

        VBox layout = new VBox(epostGroup,passwordGroup);
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("LoginMenu.css").toExternalForm());
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
