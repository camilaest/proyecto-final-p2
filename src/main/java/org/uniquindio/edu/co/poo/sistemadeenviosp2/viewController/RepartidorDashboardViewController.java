package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.*;

public class RepartidorDashboardViewController {
    private App app;
    private DataBase db;
    private Repartidor repartidor;

    @FXML private Label lblIdEnvio;
    @FXML private Label lblOrigen;
    @FXML private Label lblDestino;
    @FXML private ComboBox<EstadoEnvio> cmbEstado;

    @FXML
    private void initialize(){
        if (cmbEstado != null){
            cmbEstado.setItems(FXCollections.observableArrayList(EstadoEnvio.values()));
        }
    }

    public void setApp(App app){
        this.app = app;
    }

    public void setDataBase(DataBase db){
        this.db = db;
        loadUser();
    }

    private void loadUser(){
        if (app == null) return;
        if (app.getCurrentUser() instanceof Repartidor r){
            this.repartidor = r;
            refreshEnvio();
        }
    }

    private void refreshEnvio(){
        Envio e = repartidor != null ? repartidor.getEnvio() : null;
        if (e == null){
            lblIdEnvio.setText("Sin envío");
            lblOrigen.setText("-");
            lblDestino.setText("-");
            cmbEstado.setDisable(true);
        } else {
            lblIdEnvio.setText(e.getIdEnvio());
            lblOrigen.setText(e.getDireccionOrigen());
            lblDestino.setText(e.getDireccionDestino());
            cmbEstado.setDisable(false);
            cmbEstado.getSelectionModel().select(e.getEstadoEnvio());
        }
    }

    @FXML
    private void onActualizarEstado(){
        if (repartidor == null || repartidor.getEnvio() == null){
            new Alert(Alert.AlertType.WARNING, "No hay envío asignado", ButtonType.OK).showAndWait();
            return;
        }
        EstadoEnvio nuevo = cmbEstado.getValue();
        if (nuevo == null){
            new Alert(Alert.AlertType.WARNING, "Seleccione un estado", ButtonType.OK).showAndWait();
            return;
        }
        repartidor.getEnvio().setEstadoEnvio(nuevo);
        refreshEnvio();
        new Alert(Alert.AlertType.INFORMATION, "Estado actualizado", ButtonType.OK).showAndWait();
    }

    @FXML
    private void onLogout(){
        app.openIniciarSesion();
    }
}
