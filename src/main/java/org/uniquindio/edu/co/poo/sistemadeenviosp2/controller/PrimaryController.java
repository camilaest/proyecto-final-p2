package org.uniquindio.edu.co.poo.sistemadeenviosp2.controller;

import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;

public class PrimaryController {

    private App app;
    private DataBase db;

    public PrimaryController(DataBase db) {
        this.db = db;
    }
    public void setApp(App app) {
        this.app = app;
    }


}
