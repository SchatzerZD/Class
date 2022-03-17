package edu.ntnu.idatt1002.k103.tournament.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class CurrentTournament {

    private int WIDTH = 800;
    private int HEIGHT = 800;

    private int RECTANGLE_WIDTH = 100;
    private int RECTANGLE_HEIGHT = 50;

    private int brackets = 4;

    private Scene scene;

    public CurrentTournament(Stage stage){

        Label title = new Label("Current Tournament");
        Label tournamentTitle = new Label("Tournament Name");

        Button returnButton = new Button("X");

        Pane topScreenSpacer = new Pane();
        Pane layoutSpacer = new Pane();
        layoutSpacer.getChildren().add(tournamentTitle);

        HBox topScreen = new HBox(title,topScreenSpacer,returnButton);


        VBox tournamentBox = new VBox();

        int i = 1;
        while(i <= brackets){
            HBox tournamentRow = new HBox();

            for (int j = 0; j < i; j++) {
                Rectangle bracketRectangle = new Rectangle();
                bracketRectangle.setWidth(RECTANGLE_WIDTH);
                bracketRectangle.setHeight(RECTANGLE_HEIGHT);
                bracketRectangle.getStyleClass().add("bracketRectangle");


                tournamentRow.getChildren().add(bracketRectangle);
            }
            tournamentRow.getStyleClass().add("tournamentRow");

            tournamentBox.getChildren().add(tournamentRow);

            i *= 2;
        }




        GridPane layout = new GridPane();
        layout.add(topScreen,0,0,5,1);
        layout.add(layoutSpacer,0,1,5,1);
        layout.add(tournamentBox,0,2,5,5);

        returnButton.setOnAction(e ->{
            SceneController sceneController = new SceneController(stage);
            sceneController.switchScene(9);
        });

        tournamentBox.setId("vbox");
        layout.setId("layout");
        topScreen.setId("topScreen");
        topScreenSpacer.setId("topScreenSpacer");
        returnButton.setId("returnButton");
        layoutSpacer.setId("layoutSpacer");

        scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("CurrentTournament.css").toExternalForm());

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
