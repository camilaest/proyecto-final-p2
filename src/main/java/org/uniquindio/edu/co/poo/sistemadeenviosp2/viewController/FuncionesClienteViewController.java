package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.CrudClienteController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.FuncionesClienteController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;

public class FuncionesClienteViewController {

    private App app;
    private DataBase db;
    private FuncionesClienteController funcionesClienteController;
    private Cliente cliente;

    @FXML
    private Button btnInformacionDirecciones;

    @FXML
    private Button btnInformacionHistorial;

    @FXML
    private Button btnInformacionPaquete;

    @FXML
    private Button btnSolicitarPedido;

    @FXML
    private AnchorPane lblTitule;
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    void onHistorial(ActionEvent event) {

    }



    @FXML
    void onInformacionPaquete(ActionEvent event) {

    }

    @FXML
    void onSolicitarPedido(ActionEvent event) {

    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }

    public void setApp(App app) {
        this.app = app;
        funcionesClienteController = new FuncionesClienteController();
        funcionesClienteController.setDb(app.getDb());


    }

    public void onInformacionDirecciones(ActionEvent actionEvent) {
        app.openGestionDireccion(cliente);
    }

    public void onRegresar(ActionEvent actionEvent) {
        app.openIniciarSesion();

    }
}
