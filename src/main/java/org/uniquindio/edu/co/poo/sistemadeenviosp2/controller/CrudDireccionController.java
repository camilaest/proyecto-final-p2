package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Direccion;

import java.util.ArrayList;

public class CrudDireccionController {

    private DataBase db;

    public CrudDireccionController() {
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public ArrayList<Direccion> obtenerDirecciones() {
        return db.getListaDirecciones();
    }

    public boolean agregarDireccion(Direccion direccion) {
        if (direccion == null) return false;
        return db.agregarDireccion(direccion);
    }

    public boolean actualizarDireccion(String idActual, Direccion datos) {
        if (idActual == null || datos == null) return false;
        return db.actualizarDireccion(idActual, datos);
    }

    public boolean eliminarDireccion(String id) {
        if (id == null) return false;
        return db.eliminarDireccion(id);
    }
}
