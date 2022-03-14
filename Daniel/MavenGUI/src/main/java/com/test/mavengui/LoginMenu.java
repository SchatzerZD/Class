package com.test.mavengui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class LoginMenu {

    private double WIDTH;
    private double HEIGHT;
    private Scene scene;

    public LoginMenu(){
        WIDTH = 800;
        HEIGHT = 800;


        Label epost = new Label();
        epost.setText("E-post");
        TextField epostInput = new TextField();
        Group epostGroup = new Group(new VBox(epost,epostInput));

        Label password = new Label();
        password.setText("Passord");
        TextField passwordInput = new TextField();
        Group passwordGroup = new Group(new VBox(password,passwordInput));

        VBox layout = new VBox(epostGroup,passwordGroup);

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
