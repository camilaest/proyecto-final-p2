package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class Empresa {
    private DataBase dataBase;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Envio> listaEnvios;
    private static Empresa intance;
    private Empresa() {
        this.dataBase = new DataBase();
        this.listaUsuarios = new ArrayList<>();
        this.listaEnvios = new ArrayList<>();
    }
    public static Empresa getInstance(){
        if(intance == null){
            intance = new Empresa();
        }
        return intance;
    }

}
