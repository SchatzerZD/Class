package com.test.mavengui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TournamentApplicationController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}