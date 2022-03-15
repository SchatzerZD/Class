module edu.ntnu.idatt1002.k103.tournament {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ntnu.idatt1002.k103.tournament to javafx.fxml;
    exports edu.ntnu.idatt1002.k103.tournament;
    exports edu.ntnu.idatt1002.k103.tournament.scenes;
    opens edu.ntnu.idatt1002.k103.tournament.scenes to javafx.fxml;
}