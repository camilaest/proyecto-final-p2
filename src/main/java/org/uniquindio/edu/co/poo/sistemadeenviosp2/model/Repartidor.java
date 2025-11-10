package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Repartidor extends Usuario{
    private String idRepartidor;
    private Envio envio;
    private Disponibilidad disponibilidad;
    public Repartidor(String nombreCompleto, String id, String telefono, String email, int edad, String usuario, String contraseña, TipoUsuario tipoUsuario, Envio envio, Disponibilidad disponibilidad) {
        super(nombreCompleto, id, telefono, email, edad, usuario, contraseña, tipoUsuario);
        this.envio = envio;
        this.disponibilidad = disponibilidad;
    }
    public String getIdRepartidor() {
        return idRepartidor;
    }
    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }
    public Envio getEnvio() {
        return envio;
    }
    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void actualizarEstadoEnvio(int opcion) {
        switch (opcion) {
            case 0:
                this.envio.setEstadoEnvio(EstadoEnvio.ASIGNADO);
                break;
            case 1:
                this.envio.setEstadoEnvio(EstadoEnvio.EN_RUTA);
                break;
            case 2:
                this.envio.setEstadoEnvio(EstadoEnvio.ENTREGADO);
                break;
            case 3:
                this.envio.setEstadoEnvio(EstadoEnvio.SOLICITADO);
                break;
            case 4:
                this.envio.setEstadoEnvio(EstadoEnvio.INCIDENCIA);
                break;
        }
    }
}
