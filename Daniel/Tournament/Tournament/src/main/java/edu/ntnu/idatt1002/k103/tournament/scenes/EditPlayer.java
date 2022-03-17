package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditPlayer {

    private int WIDTH = 800;
    private int HEIGHT = 800;
    private Scene scene;

    public EditPlayer(Stage stage){

        ObservableList<String> players = FXCollections.observableArrayList(
                "Player One","Player Two","Player Three");

        ListView<String> playerList = new ListView<>(players);


        Label title = new Label("Edit Player");
        Label currentSelected = new Label();
        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");
        Label email = new Label("Email");

        TextField firstNameInput = new TextField();
        TextField lastNameInput = new TextField();
        TextField emailInput = new TextField();


        Button returnButton = new Button("X");
        Button applyChanges = new Button("Apply Changes");

        Pane topScreenSpacer = new Pane();
        Pane layoutSpacer = new Pane();
        Pane bottomRightSpacer = new Pane();

        VBox inputFieldsBox = new VBox(firstName,firstNameInput,lastName,lastNameInput,email,emailInput);
        HBox topScreen = new HBox(title,topScreenSpacer,returnButton);
        HBox bottomRight = new HBox(bottomRightSpacer,applyChanges);

        GridPane selectedTeamGrid = new GridPane();
        selectedTeamGrid.add(currentSelected,0,0,2,1);
        selectedTeamGrid.add(inputFieldsBox,1,1,1,3);
        selectedTeamGrid.add(bottomRight,1,4,1,1);
        selectedTeamGrid.getStyleClass().add("gridPane");
        selectedTeamGrid.setId("selectedTeamGrid");


        GridPane layout = new GridPane();
        layout.add(topScreen,0,0,2,1);
        layout.add(layoutSpacer,0,1,2,1);
        layout.add(playerList,0,2,1,6);
        layout.add(selectedTeamGrid,1,2,1,6);
        layout.getStyleClass().add("gridPane");

        topScreen.setId("topScreen");
        layout.setId("layout");
        returnButton.setId("returnButton");
        layoutSpacer.setId("layoutSpacer");
        bottomRight.setId("bottomRight");
        topScreenSpacer.setId("topScreenSpacer");


        returnButton.setOnAction(e ->{
            SceneController sceneController = new SceneController(stage);
            sceneController.switchScene(9);
        });


        playerList.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            currentSelected.setText(t1);
        });


        scene = new Scene(layout, WIDTH, HEIGHT);
        scene.getStylesheets().add(getClass().getResource("EditPlayer.css").toExternalForm());
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public Scene getScene() {
        return scene;
    }
}
