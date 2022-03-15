package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.stage.Stage;

public class SceneController {
    Stage stage;
    private final int REGISTER_PLAYER = 0;
    private final int REGISTER_TOURNAMENT = 1;
    private final int CURRENT_TOURNAMENT = 2;
    private final int EDIT_PLAYER = 3;
    private final int EDIT_TOURNAMENT = 4;
    private final int STATISTICS = 5;
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

            case REGISTER_TOURNAMENT:
                RegisterTournament registerTournament = new RegisterTournament(stage);
                stage.setScene(registerTournament.getScene());
                break;

            case CURRENT_TOURNAMENT:
                //TODO: Add class
                break;

            case EDIT_PLAYER:
                //TODO: Add class
                break;

            case EDIT_TOURNAMENT:
                //TODO: Add class
                break;

            case STATISTICS:
                //TODO: Add class
                break;


            case ADMIN_MENU:
                AdminMenu adminMenu = new AdminMenu(stage);
                stage.setScene(adminMenu.getScene());
                break;
        }
    }
}
