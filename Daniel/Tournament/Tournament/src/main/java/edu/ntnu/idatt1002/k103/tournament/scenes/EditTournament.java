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

import java.util.ArrayList;

public class EditTournament {
    private int WIDTH = 800;
    private int HEIGHT = 800;
    private Scene scene;

    public EditTournament(Stage stage){

        ObservableList<String> tournaments = FXCollections.observableArrayList(
                "Tournament One", "Tournament Two", "Tournament Three"
        );

        ListView<String> tournamentList = new ListView<>(tournaments);


        ArrayList<String> playerNameList = new ArrayList<>();

        for (var i=0;i<10;i++){
            playerNameList.add("Player " + (i+1));
        }


        ObservableList<HBox> deleteCells = FXCollections.observableArrayList();

        for (var i=0;i<playerNameList.size();i++){
            Button delButton = new Button("X");
            HBox delCellBox = new HBox(delButton,new Label(playerNameList.get(i)));
            deleteCells.add(delCellBox);

            delButton.setOnAction(e -> {
                deleteCells.remove(delCellBox);

            });
        }

        ListView<HBox> playerList = new ListView<>(deleteCells);





        Label title = new Label("Register Tournament");
        Label tournamentName = new Label("Tournament Name");
        Label brackets = new Label("Brackets");
        Label selectDate = new Label("Change Date:");
        Label currentSelected = new Label();


        Button returnButton = new Button("X");
        Button createTournament = new Button("Apply Changes");


        Slider bracketSlider = new Slider(2,5,2);
        bracketSlider.setShowTickMarks(true);
        bracketSlider.setShowTickLabels(true);
        bracketSlider.setMinorTickCount(1);
        bracketSlider.setMajorTickUnit(1.0);
        bracketSlider.setSnapToTicks(true);

        TextField tournamentNameInput = new TextField();


        ToggleGroup tournamentType = new ToggleGroup();

        RadioButton social = new RadioButton("Social");
        social.setToggleGroup(tournamentType);
        social.setSelected(true);

        RadioButton ntnuOpen = new RadioButton("NTNU Open");
        ntnuOpen.setToggleGroup(tournamentType);

        DatePicker calendar = new DatePicker();

        Pane topScreenSpacer = new Pane();
        Pane bottomRightSpacer = new Pane();

        VBox tournamentNameBox = new VBox(tournamentName,tournamentNameInput);
        VBox bracketSliderBox = new VBox(brackets,bracketSlider);
        VBox dateBox = new VBox(selectDate,calendar);
        VBox radioButtonsBox = new VBox(social,ntnuOpen);
        HBox topScreen = new HBox(title,topScreenSpacer,returnButton);
        HBox bottomRight = new HBox(bottomRightSpacer,createTournament);



        GridPane tournamnetGrid = new GridPane();
        tournamnetGrid.add(tournamentNameBox,0,1,2,1);
        tournamnetGrid.add(currentSelected,0,0,2,1);
        tournamnetGrid.add(bracketSliderBox,0,2,1,1);
        tournamnetGrid.add(radioButtonsBox,0,3,1,1);
        tournamnetGrid.add(playerList,0,4,1,3);
        tournamnetGrid.add(dateBox,1,2,1,1);
        tournamnetGrid.add(bottomRight,1,7,1,1);


        GridPane layout = new GridPane();
        layout.add(topScreen,0,0,2,1);
        layout.add(tournamentList,0,1,1,7);
        layout.add(tournamnetGrid,1,1,1,6);

        topScreen.setId("topScreen");
        layout.setId("layout");
        radioButtonsBox.setId("radioButtonsBox");
        bottomRight.setId("bottomRight");
        returnButton.setId("returnButton");
        playerList.setId("playerList");


        returnButton.setOnAction(e ->{
            SceneController sceneController = new SceneController(stage);
            sceneController.switchScene(9);
        });

        tournamentList.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            currentSelected.setText(t1);
        });


        scene = new Scene(layout, WIDTH, HEIGHT);
        scene.getStylesheets().add(getClass().getResource("EditTournament.css").toExternalForm());
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
