module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires net.sf.jasperreports.core;
    opens es.aketzagonzalez.jasperAgenda to javafx.fxml;
    exports es.aketzagonzalez.jasperAgenda;
}