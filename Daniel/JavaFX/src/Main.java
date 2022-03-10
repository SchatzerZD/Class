import javafx.application.Application;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent>{

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("First GUI");

        Button button = new Button();
        button.setText("yo");
        button.setPrefSize(100,100);
        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);



        Scene scene = new Scene(layout, 300, 300);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
