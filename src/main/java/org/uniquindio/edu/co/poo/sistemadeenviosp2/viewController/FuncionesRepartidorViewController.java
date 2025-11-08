package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.FuncionesClienteController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.FuncionesRepartidorController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Repartidor;

public class FuncionesRepartidorViewController {

    private App app;
    private DataBase db;
    private FuncionesRepartidorController funcionesRepartidorController;
    private Repartidor repartidor;

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public void setApp(App app) {
        this.app = app;
        funcionesRepartidorController = new FuncionesRepartidorController();
        funcionesRepartidorController.setDb(app.getDb());
    }

    @FXML
    private Button btnMisEnvios;

    @FXML
    void onConsultarMisEnvios(ActionEvent event) {

    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }

    public void onRegresar(ActionEvent actionEvent) {
        app.openIniciarSesion();

    }
}
