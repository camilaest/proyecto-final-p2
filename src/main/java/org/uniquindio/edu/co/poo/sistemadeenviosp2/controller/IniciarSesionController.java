package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import javafx.event.ActionEvent;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Administrador;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.TipoUsuario;

public class IniciarSesionController {

    private DataBase db;
    public void onIniciarSesion(ActionEvent actionEvent) {
    }
    public void setDb(DataBase db) {
        this.db = db;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDataBase (DataBase db) {
        this.db = db;
    }

    public boolean validarCredenciales(String usuario, String contraseña) {
        if (usuario == null || contraseña == null) return false;

        for (Administrador a : db.getListaAdministrador()) {

            if (usuario.equals(a.getUsuario()) && contraseña.equals(a.getContraseña())) {
                return true;
            }
        }
        return false;
    }

    public TipoUsuario obtenerTipoUsuario(String usuario, String contraseña) {
        // Verificar entre administradores
        for (Administrador a : db.getListaAdministrador()) {
            if (usuario.equals(a.getUsuario()) && contraseña.equals(a.getContraseña())) {
                return TipoUsuario.ADMINISTRADOR;
            }
        }
        // Verificar entre clientes
        for (Cliente c : db.getListaClientes()) {
            if (usuario.equals(c.getUsuario()) && contraseña.equals(c.getContraseña())) {
                return TipoUsuario.CLIENTE;
            }
        }
        // Verificar entre repartidores
        for (org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Repartidor r : db.getListaRepartidores()) {
            if (usuario.equals(r.getUsuario()) && contraseña.equals(r.getContraseña())) {
                return TipoUsuario.REPARTIDOR;
            }
        }
        return null; // No coincide con ningún usuario
    }

    public org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Usuario obtenerUsuario(String usuario, String contraseña) {
        for (Administrador a : db.getListaAdministrador()) {
            if (usuario.equals(a.getUsuario()) && contraseña.equals(a.getContraseña())) {
                return a;
            }
        }
        for (Cliente c : db.getListaClientes()) {
            if (usuario.equals(c.getUsuario()) && contraseña.equals(c.getContraseña())) {
                return c;
            }
        }
        for (org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Repartidor r : db.getListaRepartidores()) {
            if (usuario.equals(r.getUsuario()) && contraseña.equals(r.getContraseña())) {
                return r;
            }
        }
        return null;
    }


}
