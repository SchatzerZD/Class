package idatx2001.javafx.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * This is the Controller-class for the GUI designed in the FXML-file.
 * When linked to the FXML-file, the FXMLLoader-class will create an instance
 * of this class upon reading the FXML-file.
 * NOTE: It is not common to implement a constructor for the controller class.
 * Instead, you should implement the method {@code void initialize()} for any
 * initializing you would normally do in the constructor. The FXMLLoader will
 * "connect" the @FXML-tagged elements in the controller with the GUI-components
 * before calling initialize(). Hence when the initialize()-method is called,
 * the GUI and the controller have been properly linked/set up.
 */
public class Controller {

  /**
   * Create fields for each of the GUI-components you need to interact with
   * from the Java-code.
   * By using a @FXML annotation on a field/method, you are declaring that the
   * FXML loader can access the field/method even if it is private.
   */
  @FXML
  private TextField textField;

  @FXML
  public void handleEvent(ActionEvent actionEvent) {
    System.out.println("Something happened with the Textfield...");
  }

  @FXML
  protected void buttonPressed(ActionEvent actionEvent) {
    System.out.println("Button was pressed...");
    System.out.println("Text in the text field: " + this.textField.getText());
  }
}
