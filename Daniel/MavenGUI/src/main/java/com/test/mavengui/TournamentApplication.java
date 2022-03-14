package com.test.mavengui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TournamentApplication extends Application {

    double WIDTH = 800;
    double HEIGHT = 800;

    double posX1 = WIDTH/2 - WIDTH/4 + WIDTH/6;
    double posY1 = HEIGHT/2 - HEIGHT/4 + HEIGHT/6;
    double posX2 = WIDTH/2 + WIDTH/4 - WIDTH/6;
    double posY2 = HEIGHT/2 + HEIGHT/4 - HEIGHT/6;
    double outLineSize = 30;

    double fontSize = 6;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Tournament");

        Label title = new Label();
        Label subTitle = new Label();
        Text text = new Text();
        Button button = new Button();

        title.setText("Main Title");
        title.setId("mainTitle");

        subTitle.setText("Current Tournament");
        subTitle.setId("subTitle");

        text.setText("A pre-view of the current tournament.\n Tournament can be \n 'Liga' style, knockouts style or a mix of both");
        text.setId("subText");

        button.setLayoutX(600);
        button.setLayoutY(600);
        button.setText("[->");

        button.setOnAction(e ->{
            LoginMenu loginMenu = new LoginMenu();
            stage.setScene(loginMenu.getScene());
        });

        Rectangle blackOutline = new Rectangle(posX1,posY1,posX2,posY2);
        Rectangle whitePadding = new Rectangle(posX1+outLineSize,posY1+outLineSize,posX2-outLineSize,posY2-outLineSize);
        whitePadding.setFill(Color.WHITE);


        StackPane layout = new StackPane(blackOutline,whitePadding,title, subTitle, text, button);

        layout.setAlignment(title, Pos.TOP_CENTER);
        layout.setAlignment(subTitle, Pos.TOP_CENTER);
        layout.setAlignment(button, Pos.BOTTOM_RIGHT);
        layout.setId("layout");

        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("TournamentApplication.css").toExternalForm());

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}