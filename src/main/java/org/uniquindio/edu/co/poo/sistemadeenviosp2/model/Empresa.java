package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class Empresa {
    private DataBase dataBase;
    private long monto;
    private static Empresa intance;
    private Empresa() {
        // Inicializa explícitamente la base de datos para evitar NPE
        this.dataBase = new DataBase();
        this.monto = 0;
    }
    public static Empresa getInstance(){
        if(intance == null){
            intance = new Empresa();
        }
        return intance;
    }
    public long getMonto() {
        return monto;
    }
    public void setMonto(long monto) {
        this.monto = monto;
    }

}
