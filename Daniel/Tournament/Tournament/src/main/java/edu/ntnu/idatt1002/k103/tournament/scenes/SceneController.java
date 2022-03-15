package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.stage.Stage;

public class SceneController {
    Stage stage;
    private final int REGISTER_PLAYER = 0;
    private final int ADMIN_MENU = 9;

    public SceneController(Stage stage){
        this.stage = stage;
    }

    public void switchScene(int sceneNumber){
        switch (sceneNumber){
            case REGISTER_PLAYER:
                RegisterPlayer registerPlayer = new RegisterPlayer(stage);
                stage.setScene(registerPlayer.getScene());
                break;

            case ADMIN_MENU:
                AdminMenu adminMenu = new AdminMenu(stage);
                stage.setScene(adminMenu.getScene());
                break;
        }
    }
}
