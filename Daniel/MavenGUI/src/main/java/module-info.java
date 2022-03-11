module com.test.mavengui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.test.mavengui to javafx.fxml;
    exports com.test.mavengui;
}