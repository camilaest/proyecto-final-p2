package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private ArrayList<Direccion> listaDirecciones = new ArrayList<>();

    public Cliente(String nombreCompleto, String id, String telefono, String email, int edad, String usuarioSesion, String contraseña, TipoUsuario tipoUsuario) {
        super(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, tipoUsuario);


    }

    public ArrayList<Direccion> getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(ArrayList<Direccion> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }
}
