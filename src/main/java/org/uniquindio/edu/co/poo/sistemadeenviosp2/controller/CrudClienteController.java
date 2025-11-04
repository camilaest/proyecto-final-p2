package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;

import java.util.ArrayList;

public class CrudClienteController {

    private DataBase db;
    private Cliente cliente;

    public CrudClienteController() {

    }


    public void actualizarCliente(Cliente existente, Cliente nuevosDatos) {
        existente.setNombreCompleto(nuevosDatos.getNombreCompleto());
        existente.setId(nuevosDatos.getId());
        existente.setTelefono(nuevosDatos.getTelefono());
        existente.setEmail(nuevosDatos.getEmail());
        existente.setEdad(nuevosDatos.getEdad());
        existente.setUsuario(nuevosDatos.getUsuario());
        existente.setContraseña(nuevosDatos.getContraseña());
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public ArrayList<Cliente> obtenerClientes (){
        return db.getListaClientes();
    }

    public void setDataBase (DataBase db) {
        this.db = db;
    }


}
