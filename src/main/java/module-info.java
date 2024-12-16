module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires net.sf.jasperreports.core;
    opens es.aketzagonzalez.controller to javafx.fxml;
    exports es.aketzagonzalez.jasperAgenda;
}