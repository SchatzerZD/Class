package edu.ntnu.idatt1002.k103.tournament;

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