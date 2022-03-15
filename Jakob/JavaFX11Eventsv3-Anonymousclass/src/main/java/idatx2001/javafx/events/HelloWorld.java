package idatx2001.javafx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Demonstrates inner anonymous event handling.
 */
public class HelloWorld extends Application {

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

    // Create an instance of an Anonymous event handler class
    btn.setOnAction(new EventHandler<ActionEvent>() {
                      @Override
                      public void handle(ActionEvent event) {
                        System.out.println("Hello World");
                      }
                    }
    );

    BorderPane root = new BorderPane();
    root.setCenter(btn);
    Scene scene = new Scene(root, 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Override
  public void stop() {
    System.exit(0);
  }

}