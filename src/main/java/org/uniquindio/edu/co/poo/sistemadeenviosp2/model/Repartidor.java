package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Repartidor extends Usuario {

    private String IdRepartidor;
    private Disponibilidad disponibilidad;


    /**
     * @param nombreCompleto
     * @param id
     * @param telefono
     * @param email
     * @param edad
     * @param usuarioSesion
     * @param contraseña
     * @param tipoUsuario
     */
    public Repartidor(String nombreCompleto, String id, String telefono, String email, int edad, String usuarioSesion, String contraseña, TipoUsuario tipoUsuario, String IdRepartidor) {
        super(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, tipoUsuario);
        this.IdRepartidor = IdRepartidor;
        this.disponibilidad = disponibilidad;
    }

    public String getIdRepartidor() {
        return IdRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        IdRepartidor = idRepartidor;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
