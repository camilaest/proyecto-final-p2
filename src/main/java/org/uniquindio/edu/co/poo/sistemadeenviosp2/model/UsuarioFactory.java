package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public final class UsuarioFactory {

    private UsuarioFactory() {}

    public static Cliente createCliente(String nombreCompleto, String id, String telefono, String email,
                                        int edad, String usuarioSesion, String contraseña, long monto) {
        Cliente c = new Cliente(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, TipoUsuario.CLIENTE, monto);
        return c;
    }

    public static Administrador createAdministrador(String nombreCompleto, String id, String telefono, String email,
                                                    int edad, String usuarioSesion, String contraseña) {
        Administrador a = new Administrador(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, TipoUsuario.ADMINISTRADOR);
        return a;
    }

    public static Repartidor createRepartidor(String nombreCompleto, String id, String telefono, String email,
                                               int edad, String usuarioSesion, String contraseña, Envio envio, Disponibilidad disponibilidad) {
        Repartidor r = new Repartidor(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, TipoUsuario.REPARTIDOR, envio, disponibilidad);
        return r;
    }
}
