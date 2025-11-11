package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.*;

import java.util.ArrayList;

public class CrudRepartidorController {

    private DataBase db;

    public CrudRepartidorController() {
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public ArrayList<Repartidor> obtenerRepartidores() {
        return db.getListaRepartidores();
    }

    public boolean agregarRepartidor(Repartidor repartidor) {
        if (repartidor == null) return false;
        return db.agregarRepartidor(repartidor);
    }

    public boolean actualizarRepartidor(String idActual, Repartidor datos) {
        if (idActual == null || datos == null) return false;
        return db.actualizarRepartidor(idActual, datos);
    }

    public boolean eliminarRepartidor(String id) {
        if (id == null) return false;
        return db.eliminarRepartidor(id);
    }

    /**
     * Cambia el estado del envío asociado al repartidor.
     * @param idRepartidor id del repartidor
     * @param opcion 0=ASIGNADO, 1=EN_RUTA, 2=ENTREGADO, 3=SOLICITADO, 4=INCIDENCIA
     * @return true si se pudo cambiar; false si no existe repartidor o no tiene envío asignado
     */
    public boolean setEstadoEnvioRepartidor(String idRepartidor, int opcion) {
        if (idRepartidor == null) return false;
        for (Repartidor r : db.getListaRepartidores()) {
            if (idRepartidor.equals(r.getId())) {
                if (r.getEnvio() == null) return false;
                r.actualizarEstadoEnvio(opcion);
                return true;
            }
        }
        return false;
    }
}
