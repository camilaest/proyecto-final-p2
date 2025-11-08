package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Repartidor;

import java.util.ArrayList;

public class CrudRepartidorController {

    private DataBase db;
    private Repartidor repartidor;
    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    public void setDataBase (DataBase db) {
        this.db = db;
    }
    public ArrayList<Repartidor> obtenerRepartidores (){
        return db.getListaRepartidores();
    }

    public void actualizarRepartidor(Repartidor existente, Repartidor nuevosDatos) {
        existente.setNombreCompleto(nuevosDatos.getNombreCompleto());
        existente.setId(nuevosDatos.getId());
        existente.setTelefono(nuevosDatos.getTelefono());
        existente.setEmail(nuevosDatos.getEmail());
        existente.setEdad(nuevosDatos.getEdad());
        existente.setIdRepartidor(nuevosDatos.getIdRepartidor());
    }
}
