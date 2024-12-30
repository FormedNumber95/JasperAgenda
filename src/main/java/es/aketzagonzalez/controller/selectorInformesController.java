package es.aketzagonzalez.controller;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import es.aketzagonzalez.db.ConexionBBDD;
import es.aketzagonzalez.jasperAgenda.MainApp;
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

/**
 * The Class selectorInformesController.
 */
public class selectorInformesController {

    /** The btn aceptar. */
    @FXML
    private Button btnAceptar;

    /** The btn cancelar. */
    @FXML
    private Button btnCancelar;

    /** The grupo iformes. */
    @FXML
    private ToggleGroup grupoIformes;

    /** The rad informe calculos. */
    @FXML
    private RadioButton radInformeCalculos;

    /** The rad informe simple. */
    @FXML
    private RadioButton radInformeSimple;

    /** The rad informe subinforme. */
    @FXML
    private RadioButton radInformeSubinforme;

    /**
     * Boton aceptar que lanza el reporte seleccionado.
     *
     * @param event the event
     */
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
    	}else {
    		if(radInformeCalculos.isSelected()) {
    			try {
    				ConexionBBDD db=new ConexionBBDD();
    				InputStream reportStream =getClass().getResourceAsStream("/jasper/Agenda_InformePersonas_Calculos.jasper");
    				if (reportStream == null) {
    	                System.out.println("El archivo no esta ahí");
    	            }else {
    	                System.out.println("El archivo se ha encontrado");
    	            }
    	            JasperReport report = (JasperReport) JRLoader.loadObject(reportStream);
    	            Map<String, Object> parameters = new HashMap<>();
    	            parameters.put("IMAGE_PATH", db.getClass().getResource("/imagenes/").toString());
    	            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, db.getConnection());
    	            JasperViewer viewer = new JasperViewer(jprint, false);
    	            viewer.setVisible(true);
    			} catch (SQLException e) {
    				e.printStackTrace();
    			} catch (JRException e) {
    				e.printStackTrace();
    			}
    		}else {
    			try {
    				ConexionBBDD db=new ConexionBBDD();
    				InputStream reportStream =getClass().getResourceAsStream("/jasper/Agenda_InformePersonas_Subinforme.jasper");
    				if (reportStream == null) {
    	                System.out.println("El archivo no esta ahí");
    	            }else {
    	                System.out.println("El archivo se ha encontrado");
    	            }
    	            JasperReport report = (JasperReport) JRLoader.loadObject(reportStream);
    	            Map<String, Object> parameters = new HashMap<>();
    	            parameters.put("Resource_PATH", db.getClass().getResource("/jasper/").toString());
    	            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, db.getConnection());
    	            JasperViewer viewer = new JasperViewer(jprint, false);
    	            viewer.setVisible(true);
    			} catch (SQLException e) {
    				e.printStackTrace();
    			} catch (JRException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }

    /**
     * Accion cancelar.
     *
     * @param event the event
     */
    @FXML
    void accionCancelar(ActionEvent event) {
    	MainApp.getStage().close();
    }

}
