module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens es.aketzagonzalez.jasperAgenda to javafx.fxml;
    exports es.aketzagonzalez.jasperAgenda;
}