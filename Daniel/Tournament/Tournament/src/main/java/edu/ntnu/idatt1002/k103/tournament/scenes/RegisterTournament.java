package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterTournament {
    private int WIDTH = 800;
    private int HEIGHT = 800;
    private Scene scene;


    public RegisterTournament(Stage stage){

        String[] teamList = new String[]{"Team One","Team Two","Team Three","Team Four","Team Five","Team Six","Team Seven"};

        Label title = new Label("Register Tournament");
        Label tournamentName = new Label("Tournament Name");
        Label brackets = new Label("Brackets");
        Label selectDate = new Label("Select Date:");

        Button returnButton = new Button("X");
        Button createTournament = new Button("Create Tournament");

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

        VBox checkBoxList = new VBox();
        VBox tournamentNameBox = new VBox(tournamentName,tournamentNameInput);
        VBox bracketSliderBox = new VBox(brackets,bracketSlider);
        VBox dateBox = new VBox(selectDate,calendar);
        VBox radioButtonsBox = new VBox(social,ntnuOpen);
        HBox topScreen = new HBox(title,topScreenSpacer,returnButton);
        HBox bottomRight = new HBox(bottomRightSpacer,createTournament);


        for(var i=0;i<teamList.length;i++){
            CheckBox checkBox = new CheckBox(teamList[i]);
            checkBoxList.getChildren().add(checkBox);
        }

        GridPane layout = new GridPane();
        layout.add(topScreen,0,0,2,1);
        layout.add(tournamentNameBox,0,1,2,1);
        layout.add(bracketSliderBox,0,2,1,1);
        layout.add(radioButtonsBox,0,3,1,1);
        layout.add(checkBoxList,0,4,1,3);
        layout.add(dateBox,1,2,1,1);
        layout.add(bottomRight,1,7,1,1);


        topScreen.setId("topScreen");
        layout.setId("layout");
        checkBoxList.setId("checkBoxList");
        radioButtonsBox.setId("radioButtonsBox");
        bottomRight.setId("bottomRight");
        returnButton.setId("returnButton");

        StackPane stackPane = new StackPane(layout);
        stackPane.setAlignment(Pos.CENTER);


        returnButton.setOnAction(e ->{
            SceneController sceneController = new SceneController(stage);
            sceneController.switchScene(9);
        });


        scene = new Scene(stackPane, WIDTH, HEIGHT);
        scene.getStylesheets().add(getClass().getResource("RegisterTournament.css").toExternalForm());
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
