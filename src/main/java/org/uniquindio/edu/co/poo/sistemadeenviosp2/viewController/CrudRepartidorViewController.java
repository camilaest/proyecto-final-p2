package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.CrudClienteController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.CrudRepartidorController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.*;

public class CrudRepartidorViewController {

    private App app;
    private DataBase db;
    private Administrador administrador;

    ObservableList<Repartidor> listaRepartidores = FXCollections.observableArrayList();
    private Repartidor selectRepartidor;
    private CrudRepartidorController crudRepartidorController;
    private org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.IniciarSesionController iniciarSesionController;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Repartidor, Disponibilidad> columDisponibilidad;

    @FXML
    private TableColumn<Repartidor, String> columCedula;

    @FXML
    private TableColumn<Repartidor, Integer> columEdad;

    @FXML
    private TableColumn<Repartidor, String> columEmail;

    @FXML
    private TableColumn<Repartidor, String> columIdRepartidor;

    @FXML
    private TableColumn<Repartidor, String> columNombre;

    @FXML
    private TableColumn<Repartidor, String> columTelefono;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblEdad;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblEstadoDisponibilidad;

    @FXML
    private Label lblIdRepartidor;

    @FXML
    private Label lblNombreCompleto;

    @FXML
    private Label lblTelefono;

    @FXML
    private TableView<Repartidor> tblRepartidor;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtEmail;

    @FXML
    private ComboBox<Disponibilidad> txtEstadoDisponibilidad;

    @FXML
    private TextField txtIdRepartidor;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContraseña;

    @FXML
    void onActualizar(ActionEvent event) {
        Repartidor seleccionado = tblRepartidor.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error Debe seleccionar un repartidor para actualizar");
            return;
        }

        Repartidor nuevosDatos = new Repartidor(
                txtNombre.getText(),
                txtCedula.getText(),
                txtTelefono.getText(),
                txtEmail.getText(),
                Integer.parseInt(txtEdad.getText()),
                txtUsuario.getText(),
                txtContraseña.getText(),
                TipoUsuario.ADMINISTRADOR,
                txtIdRepartidor.getText()
                //txtEstadoDisponibilidad.getItems()
        );

        crudRepartidorController.actualizarRepartidor(seleccionado, nuevosDatos);
        tblRepartidor.refresh();

        mostrarAlerta("Éxito Repartidor actualizado correctamente");
        limpiarCampos();

    }

    @FXML
    void onEliminar(ActionEvent event) {
        Repartidor seleccionado = tblRepartidor.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error Debe seleccionar un repartidor para eliminarlo");
            return;
        }


        db.getListaRepartidores().remove(seleccionado);
        listaRepartidores.remove(seleccionado);

        mostrarAlerta("Éxito Repartidor eliminado correctamente");


        limpiarCampos();

    }

    @FXML
    void onRegistrar(ActionEvent event) {
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText().trim();
        String idRepartidor = txtIdRepartidor.getText();
        Disponibilidad  disponibilidad = txtEstadoDisponibilidad.getValue();
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();



        if (nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty() ||
                email.isEmpty()  || edad.isEmpty() || idRepartidor.isEmpty() || disponibilidad == null) {
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

        Repartidor nuevo = new Repartidor(nombre, cedula, telefono, email, edadP, usuario, contraseña, TipoUsuario.REPARTIDOR, idRepartidor);
        nuevo.setDisponibilidad(txtEstadoDisponibilidad.getValue()); //setear la disponibilidad cuando se crea a repartidor
        //como manejar edad, edad no se limpia en la tabla ???
        db.agregarRepartidor(nuevo); // se agrega a la lista observable
        listaRepartidores.add(nuevo);
        limpiarCampos();

    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtCedula.clear();
        txtTelefono.clear();
        txtEmail.clear();
        txtEdad.clear();
        txtIdRepartidor.clear();
        //txtEstadoDisponibilidad.clear();

    }

    @FXML
    void onRegresar(ActionEvent event) {

        app.openFuncionesAdministrador(administrador);

    }

    @FXML
    public void initialize() {
        txtEstadoDisponibilidad.getItems().addAll(Disponibilidad.values());
        txtEstadoDisponibilidad.setValue(Disponibilidad.ACTIVO);
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    private void obtenerRepartidores() {

        listaRepartidores.addAll(crudRepartidorController.obtenerRepartidores());
        tblRepartidor.setItems(listaRepartidores);
    }

    public void setApp(App app) {
        this.app = app;
        crudRepartidorController = new CrudRepartidorController();
        crudRepartidorController.setDb(app.getDb());
        obtenerRepartidores();
        initBinding();
    }

    private void initBinding() {
        columNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
        columCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        columIdRepartidor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdRepartidor()));
        columEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        columTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        columDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }

}
