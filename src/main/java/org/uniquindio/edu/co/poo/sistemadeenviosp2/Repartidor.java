package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Repartidor extends Usuario{
    private String idRepartidor;
    public Repartidor(String nombreCompleto, String id, String telefono, String email, int edad, String usuario, String contraseña) {
        super(nombreCompleto, id, telefono, email, edad, usuario, contraseña);
    }
    public String getIdRepartidor() {
        return idRepartidor;
    }
    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }
}
