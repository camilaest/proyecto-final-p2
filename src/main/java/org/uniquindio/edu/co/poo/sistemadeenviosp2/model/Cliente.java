package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Cliente extends Usuario {

    public Cliente(String nombreCompleto, String id, String telefono, String email, int edad, String usuarioSesion, String contraseña, TipoUsuario tipoUsuario) {
        super(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, tipoUsuario);

    }
}
