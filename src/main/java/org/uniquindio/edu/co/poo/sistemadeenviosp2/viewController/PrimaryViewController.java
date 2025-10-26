package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.PrimaryController;

public class PrimaryViewController {

    private PrimaryController primaryController;
    private App app;

    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
        if (this.app != null){
            this.primaryController.setApp(app);
        }
    }

    @FXML
    private Button buttonEntrar;

    @FXML
    private Label lblIngresar;

    @FXML
    private Label lblTitulo;

    @FXML
    void onOpenEntrar(ActionEvent event) {
        app.openIniciarSesion();
    }

    public void setApp(App app) {
        this.app = app;
        if (this.primaryController != null){
            this.primaryController.setApp(app);
        }
    }
    @FXML
    void initialize() {

    }

}
