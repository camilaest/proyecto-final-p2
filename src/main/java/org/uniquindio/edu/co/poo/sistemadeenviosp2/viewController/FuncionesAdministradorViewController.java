package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.FuncionesAdministradorController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.FuncionesClienteController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Administrador;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;

public class FuncionesAdministradorViewController {

    private App app;
    private DataBase db;
    private FuncionesAdministradorController funcionesAdministradorController;
    private Administrador administrador;

    @FXML
    private Button btnGestionarCliente;

    @FXML
    private Button btnGestionarRepartidor;

    @FXML
    private Button btnRegresar;



    @FXML
    void onGestionarCliente(ActionEvent event) {
        app.openCrudCliente();

    }

    @FXML
    void onGestionarRepartidor(ActionEvent event) {
        app.openCrudRepartidor();

    }

    @FXML
    void onRegresar(ActionEvent event) {
        app.openIniciarSesion();

    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }

    public void setApp(App app) {
        this.app = app;
        funcionesAdministradorController = new FuncionesAdministradorController();
        funcionesAdministradorController.setDb(app.getDb());


    }



}

