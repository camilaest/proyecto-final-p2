package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Administrador;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.TipoUsuario;

public class IniciarSesionViewController {

    private App app;
    private DataBase db;
    private org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.IniciarSesionController iniciarSesionController;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button toggleButton;
    @FXML
    private TextField textField;

    private boolean passwordVisible = false;

    @FXML
    public void initialize() {
        textField.textProperty().bindBidirectional(passwordField.textProperty());
    }

    @FXML
    private Label txtAdministrador;

    @FXML
    private TextField txtContraseña;

    @FXML
    private Label txtContraseñaAdmin;

    @FXML
    private TextField txtUsuarioSesion;

    @FXML
    void onIniciarSesion(ActionEvent event) {
        String usuario = txtUsuarioSesion.getText().trim();
        //String contraseña = txtContraseña.getText().trim();
        String contraseña = passwordField.isVisible() ? passwordField.getText() : textField.getText();

        if (usuario.isEmpty() || contraseña.isEmpty()) {
            mostrarAlerta("Error", "Debe ingresar usuario y contraseña");
            txtUsuarioSesion.requestFocus();
            return;
        }

        // Buscar si las credenciales existen y obtener el tipo de usuario
        TipoUsuario tipo = iniciarSesionController.obtenerTipoUsuario(usuario, contraseña);

        if (tipo == null) {

            mostrarAlerta("Acceso denegado", "Usuario o contraseña incorrectos");
            txtUsuarioSesion.clear();
            txtContraseña.clear();
            txtUsuarioSesion.requestFocus();
            return;
        }

        // Redirigir según el tipo de usuario
        switch (tipo) {
            case ADMINISTRADOR:
                Administrador administrador = iniciarSesionController.obtenerAdministrador(usuario, contraseña);
                app.openFuncionesAdministrador(administrador);  // Interfaz del administrador
                System.out.println("es admin");
                break;
            case CLIENTE:
                Cliente cliente = iniciarSesionController.obtenerCliente(usuario, contraseña);
                app.openFuncionesCliente(cliente);

                System.out.println("es cliente");
                break;
            default:
                mostrarAlerta("Error", "Tipo de usuario no reconocido");
                break;
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
        iniciarSesionController = new org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.IniciarSesionController();
        iniciarSesionController.setDb(app.getDb());
        //initBinding();
    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }


    public void ocultarContraseña(ActionEvent actionEvent) {
        passwordVisible = !passwordVisible;

        if (passwordVisible) {
            textField.setVisible(true);
            textField.setManaged(true);
            passwordField.setVisible(false);
            passwordField.setManaged(false);
            toggleButton.setText("🙈");
        } else {
            textField.setVisible(false);
            textField.setManaged(false);
            passwordField.setVisible(true);
            passwordField.setManaged(true);
            toggleButton.setText("👁️");
        }
    }
}
