package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Direccion;

import java.util.ArrayList;

public class GestionDireccionController {

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    private DataBase db;


    public ArrayList<Direccion> obtenerDirecciones() {
        if (cliente == null || cliente.getListaDirecciones() == null) {
            return new ArrayList<>();
        }
        return cliente.getListaDirecciones();
    }

    public void setDataBase (DataBase db) {
        this.db = db;
    }
}
