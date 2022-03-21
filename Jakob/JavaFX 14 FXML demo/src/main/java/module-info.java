module JavaFX.Events {
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  opens idatx2001.javafx.fxml to javafx.fxml;
  exports idatx2001.javafx.fxml;
}
