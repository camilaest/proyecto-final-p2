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
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;

public class CrudClienteViewController {

    private App app;
    private DataBase db;
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private Cliente selectCliente;
    private CrudClienteController crudClienteController;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private Button btnRegresarRegistrarCliente;

    @FXML
    private TableColumn<Cliente, String > columCedula;
    @FXML
    private TableColumn<Cliente, String > columTelefono;
    @FXML
    private TableColumn<Cliente, String > columEmail;
    @FXML
    private TableColumn<Cliente, String > columUsuario;
    @FXML
    private TableColumn<Cliente, Integer > columEdad;

    @FXML
    private TableColumn<Cliente, String> columnNombre;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblContraseña;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNombreCompleto;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblUsuario;

    @FXML
    private TableView<Cliente> tblCliente;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombreCompelto;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtUsuario;

    @FXML
    void onEliminarCliente(ActionEvent event) {

    }

    @FXML
    void inicialize(){




    }

    private void initBinding() {
        columnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
        columCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        columEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        columTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario()));
        columEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());



    }

    private void obtenerClientes() {

        listaClientes.addAll(crudClienteController.obtenerClientes());
        tblCliente.setItems(listaClientes);
    }

    @FXML
    void onRegistrarCliente(ActionEvent event) {
        String nombre = txtNombreCompelto.getText();
        String cedula = txtCedula.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();


        String usuario = txtUsuario.getText();
        String contrasena = txtContraseña.getText();

        if (nombre.isEmpty() || cedula.isEmpty()) {
            mostrarAlerta("Por favor completa al menos el nombre y la cédula.");
            return;
        }

        Cliente nuevo = new Cliente(nombre, cedula, telefono, email,12,  usuario, contrasena);
        db.agregarCliente(nuevo); // se agrega a la lista observable
        limpiarCampos();

    }

    @FXML
    void onRegresarRegistroCliente(ActionEvent event) {
        app.openPrimary();
    }

    public void setApp(App app) {
        this.app = app;
        crudClienteController = new CrudClienteController();
        crudClienteController.setDb(app.getDb());
        obtenerClientes();
        initBinding();


    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }

    private void limpiarCampos() {
        txtNombreCompelto.clear();
        txtCedula.clear();
        txtTelefono.clear();
        txtEmail.clear();
        txtUsuario.clear();
        txtContraseña.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Campos incompletos");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
