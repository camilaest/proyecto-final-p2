package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Repartidor extends Usuario{
    private String idRepartidor;
    public Repartidor(String nombreCompleto, String id, String telefono, String email, int edad, String usuario, String contraseña, TipoUsuario tipoUsuario) {
        super(nombreCompleto, id, telefono, email, edad, usuario, contraseña, tipoUsuario);
    }
    public String getIdRepartidor() {
        return idRepartidor;
    }
    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }
}
