package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.TipoUsuario;

public class IniciarSesionViewController {

    private App app;
    private DataBase db;
    private org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.IniciarSesionController iniciarSesionController;

    @FXML
    private Button btnIniciarSesion;

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
        String contraseña = txtContraseña.getText().trim();

        if (usuario.isEmpty() || contraseña.isEmpty()) {
            mostrarAlerta("Error", "Debe ingresar usuario y contraseña");
            txtUsuarioSesion.requestFocus();
            return;
        }

        // Buscar si las credenciales existen y obtener el tipo de usuario
        TipoUsuario tipo = iniciarSesionController.obtenerTipoUsuario(usuario, contraseña);

        if (tipo == null) {
            // Si no se encontró el usuario
            mostrarAlerta("Acceso denegado", "Usuario o contraseña incorrectos");
            txtUsuarioSesion.clear();
            txtContraseña.clear();
            txtUsuarioSesion.requestFocus();
            return;
        }

        // Establecer usuario actual
        org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Usuario user = iniciarSesionController.obtenerUsuario(usuario, contraseña);
        app.setCurrentUser(user);

        // Redirigir según el tipo de usuario
        switch (tipo) {
            case ADMINISTRADOR:
                app.openAdminDashboard();
                break;
            case CLIENTE:
                app.openClienteDashboard();
                break;
            case REPARTIDOR:
                app.openRepartidorDashboard();
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
}
