package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Envio;

import java.util.ArrayList;

public class CrudEnvioController {

    private DataBase db;

    public CrudEnvioController() {
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public ArrayList<Envio> obtenerEnvios() {
        return db.getListaEnvios();
    }

    public boolean agregarEnvio(Envio envio) {
        if (envio == null) return false;
        return db.agregarEnvio(envio);
    }

    public boolean actualizarEnvio(String idActual, Envio datos) {
        if (idActual == null || datos == null) return false;
        return db.actualizarEnvio(idActual, datos);
    }

    public boolean eliminarEnvio(String id) {
        if (id == null) return false;
        return db.eliminarEnvio(id);
    }
}
