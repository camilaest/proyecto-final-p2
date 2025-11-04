package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.CrudClienteController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.GestionDireccionController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Direccion;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.TipoUsuario;

import java.util.ArrayList;

public class GestionDireccionViewController {

    private App app;
    private DataBase db;
    private Cliente cliente;
    ObservableList<Direccion> listaDirecciones = FXCollections.observableArrayList();
    private Direccion selectDireccion;
    private GestionDireccionController gestionDireccionController;

        @FXML
        private Button btnActualizarDireccion;

        @FXML
        private Button btnAgregarDireccion;

        @FXML
        private Button btnEliminarDireccion;

        @FXML
        private Button btnRegresar;

        @FXML
        private TableColumn<Direccion, String> columCalle;

        @FXML
        private TableColumn<Direccion, String> columCiudad;

        @FXML
        private TableColumn<Direccion, String> columCoordenadas;

        @FXML
        private TableColumn<Direccion, String> columId;

        @FXML
        private Label lblAlias;

        @FXML
        private Label lblCalle;

        @FXML
        private Label lblCoordenadas;

        @FXML
        private Label lblId;

        @FXML
        private TextField txtAlias;

        @FXML
        private TextField txtCalle;

        @FXML
        private Label lblCiudad;

        @FXML
        private TextField txtCoordenadas;

        @FXML
        private Label txtGestionDireccion;

        @FXML
        private TextField txtId;

        @FXML
        private TableView<Direccion> tblDireccion;

        @FXML
        void onActualizar(ActionEvent event) {

        }




    @FXML
    void onEliminar(ActionEvent event) {
        Direccion seleccionada = tblDireccion.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarAlerta("Selecciona una dirección para eliminar");
            return;
        }
        cliente.getListaDirecciones().remove(seleccionada);
        listaDirecciones.remove(seleccionada);
        limpiarCampos();
        mostrarAlerta("Dirección eliminada correctamente");
    }

        @FXML
        void onRegresar(ActionEvent event) {
            app.openFuncionesCliente(cliente);

        }

    public void setApp(App app) {
        this.app = app;
        if (gestionDireccionController == null) {
            gestionDireccionController = new GestionDireccionController();
        }
        gestionDireccionController.setDb(app.getDb());

    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }

    private void limpiarCampos() {
        txtId.clear();
        txtCoordenadas.clear();
        txtCalle.clear();
        txtAlias.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void initBinding() {
        columCalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCalle()));
        columId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        columCoordenadas.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoordenadas()));
        columCiudad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCiudad()));
    }


    private void obtenerDirecciones() {
        listaDirecciones.clear();
        if (gestionDireccionController == null) return;

        var dirs = gestionDireccionController.obtenerDirecciones();
        if (dirs == null) dirs = new ArrayList<>(); // cinturón y tirantes

        listaDirecciones.addAll(dirs);
        tblDireccion.setItems(listaDirecciones);
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

        if (gestionDireccionController == null) {
            gestionDireccionController = new GestionDireccionController();
            gestionDireccionController.setDb(app != null ? app.getDb() : db);
        }
        gestionDireccionController.setCliente(cliente);

        initBinding();
        obtenerDirecciones();
    }


    public void onAgregarDireccion(ActionEvent actionEvent) {
    }
}


