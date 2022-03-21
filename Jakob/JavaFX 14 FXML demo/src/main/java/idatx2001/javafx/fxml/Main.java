package idatx2001.javafx.fxml;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("sample.fxml"));

      primaryStage.setTitle("Hello World");
      primaryStage.setScene(new Scene(root, 600, 300));
      primaryStage.show();
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }


  public static void main(String[] args) {
    launch(args);
  }
}
