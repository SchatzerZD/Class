package idatx2001.javafx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Demonstrates inner event handler class for event handling.
 */
public class HelloWorld extends Application  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Button btn = new Button();
        btn.setText("Hello World");
        btn.setOnAction(new ButtonEventHandler());

        BorderPane root = new BorderPane();
        root.setCenter(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop()
    {
        System.exit(0);
    }

    private class ButtonEventHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent ev)
        {
            System.out.println("Hello World");
        }
    }
}