package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Repartidor;

public class FuncionesRepartidorController {

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


}
