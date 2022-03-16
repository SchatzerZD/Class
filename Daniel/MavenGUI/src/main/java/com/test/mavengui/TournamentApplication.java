package com.test.mavengui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TournamentApplication extends Application {

    double WIDTH = 800;
    double HEIGHT = 800;


    @Override
    public void start(Stage stage) throws IOException {

        ObservableList<String> stringList = FXCollections.observableArrayList("yo","what","ok","league");
        ListView<String> list = new ListView<>(stringList);

        Label ok = new Label("OK");

        HBox layout = new HBox(list,ok);

        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.getStylesheets().add(getClass().getResource("TournamentApplication.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}