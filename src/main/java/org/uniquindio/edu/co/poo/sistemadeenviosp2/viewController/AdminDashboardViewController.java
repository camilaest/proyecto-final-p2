package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.*;

public class AdminDashboardViewController {

    private App app;
    private DataBase db;

    private final ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private final ObservableList<Repartidor> repartidores = FXCollections.observableArrayList();
    private final ObservableList<Envio> envios = FXCollections.observableArrayList();

    // Clientes
    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, String> colClienteNombre;
    @FXML private TableColumn<Cliente, String> colClienteId;
    @FXML private TableColumn<Cliente, String> colClienteUsuario;
    @FXML private TableColumn<Cliente, String> colClienteEmail;
    @FXML private TableColumn<Cliente, String> colClienteTelefono;

    @FXML private TextField txtCliNombre;
    @FXML private TextField txtCliId;
    @FXML private TextField txtCliUsuario;
    @FXML private PasswordField txtCliPass;
    @FXML private TextField txtCliTelefono;
    @FXML private TextField txtCliEmail;
    @FXML private TextField txtCliEdad;
    @FXML private TextField txtCliMonto;

    // Repartidores
    @FXML private TableView<Repartidor> tblRepartidores;
    @FXML private TableColumn<Repartidor, String> colRepNombre;
    @FXML private TableColumn<Repartidor, String> colRepId;
    @FXML private TableColumn<Repartidor, String> colRepUsuario;
    @FXML private TableColumn<Repartidor, String> colRepEmail;
    @FXML private TableColumn<Repartidor, String> colRepTelefono;

    @FXML private TextField txtRepNombre;
    @FXML private TextField txtRepId;
    @FXML private TextField txtRepUsuario;
    @FXML private PasswordField txtRepPass;
    @FXML private TextField txtRepTelefono;
    @FXML private TextField txtRepEmail;
    @FXML private TextField txtRepEdad;

    // Envios
    @FXML private TableView<Envio> tblEnvios;
    @FXML private TableColumn<Envio, String> colEnvioId;
    @FXML private TableColumn<Envio, String> colEnvioOrigen;
    @FXML private TableColumn<Envio, String> colEnvioDestino;
    @FXML private TableColumn<Envio, Number> colEnvioCosto;
    @FXML private TableColumn<Envio, String> colEnvioEstado;

    // Empresa
    @FXML private Label lblMontoEmpresa;

    @FXML
    private void initialize(){
        if (colClienteNombre != null){
            colClienteNombre.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNombreCompleto()));
            colClienteId.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getId()));
            colClienteUsuario.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getUsuario()));
            colClienteEmail.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getEmail()));
            colClienteTelefono.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTelefono()));
        }
        if (colRepNombre != null){
            colRepNombre.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNombreCompleto()));
            colRepId.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getId()));
            colRepUsuario.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getUsuario()));
            colRepEmail.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getEmail()));
            colRepTelefono.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTelefono()));
        }
        if (colEnvioId != null){
            colEnvioId.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getIdEnvio()));
            colEnvioOrigen.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDireccionOrigen()));
            colEnvioDestino.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDireccionDestino()));
            colEnvioCosto.setCellValueFactory(cell -> new javafx.beans.property.SimpleLongProperty(cell.getValue().getCosto()));
            colEnvioEstado.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getEstadoEnvio())));
        }
    }

    public void setApp(App app){
        this.app = app;
    }
    public void setDataBase(DataBase db){
        this.db = db;
        loadData();
    }

    private void loadData(){
        if (db == null) return;
        clientes.setAll(db.getListaClientes());
        if (tblClientes != null) tblClientes.setItems(clientes);
        repartidores.setAll(db.getListaRepartidores());
        if (tblRepartidores != null) tblRepartidores.setItems(repartidores);
        envios.setAll(db.getListaEnvios());
        if (tblEnvios != null) tblEnvios.setItems(envios);
        if (lblMontoEmpresa != null){
            lblMontoEmpresa.setText("$ " + Empresa.getInstance().getMonto());
        }
    }

    @FXML
    private void onRegistrarCliente(){
        try {
            String nombre = txtCliNombre.getText();
            String id = txtCliId.getText();
            String usuario = txtCliUsuario.getText();
            String pass = txtCliPass.getText();
            String tel = txtCliTelefono.getText();
            String email = txtCliEmail.getText();
            int edad = Integer.parseInt(txtCliEdad.getText());
            long monto = Long.parseLong(txtCliMonto.getText());
            Cliente c = UsuarioFactory.createCliente(nombre, id, tel, email, edad, usuario, pass, monto);
            if (db.agregarCliente(c)){
                clientes.add(c);
                showInfo("Cliente registrado");
            } else {
                showWarn("Ya existe un cliente con esa cédula");
            }
        } catch (Exception ex){
            showError("Datos inválidos: " + ex.getMessage());
        }
    }

    @FXML
    private void onEliminarCliente(){
        Cliente sel = tblClientes.getSelectionModel().getSelectedItem();
        if (sel == null){ showWarn("Seleccione un cliente"); return; }
        if (db.eliminarCliente(sel.getId())){
            clientes.remove(sel);
            showInfo("Cliente eliminado");
        } else {
            showError("No se pudo eliminar");
        }
    }

    @FXML
    private void onRegistrarRepartidor(){
        try {
            String nombre = txtRepNombre.getText();
            String id = txtRepId.getText();
            String usuario = txtRepUsuario.getText();
            String pass = txtRepPass.getText();
            String tel = txtRepTelefono.getText();
            String email = txtRepEmail.getText();
            int edad = Integer.parseInt(txtRepEdad.getText());
            // Por defecto sin envío asignado y disponible
            Repartidor r = UsuarioFactory.createRepartidor(nombre, id, tel, email, edad, usuario, pass, null, Disponibilidad.ACTIVO);
            if (db.agregarRepartidor(r)){
                repartidores.add(r);
                showInfo("Repartidor registrado");
            } else {
                showWarn("Ya existe un repartidor con esa cédula");
            }
        } catch (Exception ex){
            showError("Datos inválidos: " + ex.getMessage());
        }
    }

    @FXML
    private void onEliminarRepartidor(){
        Repartidor sel = tblRepartidores.getSelectionModel().getSelectedItem();
        if (sel == null){ showWarn("Seleccione un repartidor"); return; }
        if (db.eliminarRepartidor(sel.getId())){
            repartidores.remove(sel);
            showInfo("Repartidor eliminado");
        } else {
            showError("No se pudo eliminar");
        }
    }

    @FXML
    private void onLogout(){
        app.openIniciarSesion();
    }

    private void showInfo(String msg){ new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK).showAndWait(); }
    private void showWarn(String msg){ new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK).showAndWait(); }
    private void showError(String msg){ new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK).showAndWait(); }
}
