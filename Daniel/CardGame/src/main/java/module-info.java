module no.ntnu.idatx2001.oblig3.cardgame {
    requires javafx.controls;
    requires javafx.fxml;


    exports no.ntnu.idatx2001.oblig3.cardgame.objects;
    opens no.ntnu.idatx2001.oblig3.cardgame.objects to javafx.fxml;
    exports no.ntnu.idatx2001.oblig3.cardgame.javafx;
    opens no.ntnu.idatx2001.oblig3.cardgame.javafx to javafx.fxml;
}