module no.ntnu.idatx2001.wargames {
    requires javafx.controls;
    requires javafx.fxml;


    opens no.ntnu.idatx2001.wargames to javafx.fxml;
    exports no.ntnu.idatx2001.wargames;
    exports no.ntnu.idatx2001.wargames.objects.units;
    opens no.ntnu.idatx2001.wargames.objects.units to javafx.fxml;
}