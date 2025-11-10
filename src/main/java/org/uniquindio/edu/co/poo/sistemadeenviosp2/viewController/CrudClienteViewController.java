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
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.TipoUsuario;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.UsuarioFactory;

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
    private TableColumn<Cliente, String > columMetodo;

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
    private Label lbledad;

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
    private TextField txtEdad;

    @FXML
    void onEliminarCliente(ActionEvent event) {
        Cliente seleccionado = tblCliente.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error Debe seleccionar un cliente para eliminarlo");
            return;
        }

        // Eliminar directamente de la base de datos y de la lista observable
        db.getListaClientes().remove(seleccionado);
        listaClientes.remove(seleccionado);

        mostrarAlerta("Éxito Cliente eliminado correctamente");

        // (opcional) limpiar campos después de eliminar
        limpiarCampos();

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
        columMetodo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMetodoCreacion()));

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
        String contraseña = txtContraseña.getText();
        String edad = txtEdad.getText().trim();

        if (nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty() ||
                email.isEmpty() || usuario.isEmpty() || contraseña.isEmpty() || edad.isEmpty()) {
            mostrarAlerta("Error Debe llenar todos los campos antes de registrar");
            return;
        }

        int edadP;
        try {
            edadP = Integer.parseInt(edad);
            if (edadP < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            mostrarAlerta("Error Edad debe ser un número entero válido (≥ 0)");
            txtEdad.requestFocus();
            return;
        }

        Cliente nuevo = UsuarioFactory.createCliente(nombre, cedula, telefono, email, edadP, usuario, contraseña);
        db.agregarCliente(nuevo);
        listaClientes.add(nuevo);
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
        txtEdad.clear();

    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
