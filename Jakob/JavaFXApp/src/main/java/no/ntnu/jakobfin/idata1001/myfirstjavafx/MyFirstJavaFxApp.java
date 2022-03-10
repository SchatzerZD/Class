package no.ntnu.jakobfin.idata1001.myfirstjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MyFirstJavaFxApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Button button1 = new Button("Click me! 1");
        Button button2 = new Button("Click me! 2");
        Button button3 = new Button("Click me! 3");
        Button button4 = new Button("Click me! 4");
        Button button5 = new Button("Click me! 5");

        BorderPane rootNode = new BorderPane();

        rootNode.setTop(button1);
        rootNode.setLeft(button2);
        rootNode.setCenter(button3);
        rootNode.setRight(button4);
        rootNode.setBottom(button5);

        //VBox vbox1 = new VBox();
        //VBox vbox2 = new VBox();

        //rootNode.setVgap(10);
        //rootNode.setHgap(40);

       /** rootNode.add(button1,1,1);
        rootNode.add(button2,5,2);
        rootNode.add(button3,1,3);
        rootNode.add(button4,2,1);
        rootNode.add(button5,2,4);*/


        /**vbox1.getChildren().add(button1);
        vbox1.getChildren().add(button2);
        vbox1.getChildren().add(button3);
        vbox2.getChildren().add(button4);
        vbox2.getChildren().add(button5);
        rootNode.getChildren().add(vbox1);
        rootNode.getChildren().add(vbox2);*/

        Scene scene = new Scene(rootNode,500,250);

        stage.setScene(scene);
        stage.setTitle("My First JavaFx App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
