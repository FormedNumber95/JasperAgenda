package es.aketzagonzalez.controller;

import java.io.InputStream;
import java.sql.SQLException;

import es.aketzagonzalez.db.ConexionBBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class selectorInformesController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private ToggleGroup grupoIformes;

    @FXML
    private RadioButton radInformeCalculos;

    @FXML
    private RadioButton radInformeSimple;

    @FXML
    private RadioButton radInformeSubinforme;

    @FXML
    void accionAceptar(ActionEvent event) {
    	if(radInformeSimple.isSelected()) {
    		 try {
    				ConexionBBDD db=new ConexionBBDD();
    				InputStream reportStream =getClass().getResourceAsStream("/jasper/Agenda_InformePersonas.jasper");
    				if (reportStream == null) {
    	                System.out.println("El archivo no esta ahí");
    	            }else {
    	                System.out.println("El archivo se ha encontrado");
    	            }
    	            JasperReport report = (JasperReport) JRLoader.loadObject(reportStream);
    	            JasperPrint jprint = JasperFillManager.fillReport(report, null, db.getConnection());
    	            JasperViewer viewer = new JasperViewer(jprint, false);
    	            viewer.setVisible(true);
    			} catch (SQLException e) {
    				e.printStackTrace();
    			} catch (JRException e) {
    				e.printStackTrace();
    			}
    	}
    }

    @FXML
    void accionCancelar(ActionEvent event) {

    }

}
