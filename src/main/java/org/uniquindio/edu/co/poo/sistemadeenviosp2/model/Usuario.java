package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Usuario {
    private String nombreCompleto;
    private String id;
    private String telefono;
    private String email;
    private int edad;
    private String usuario;
    private String contraseña;

    /**
     * @param nombreCompleto
     * @param id
     * @param telefono
     * @param email
     * @param edad
     * @param usuario
     * @param contraseña
     */


    public Usuario (String nombreCompleto, String id, String telefono, String email, int edad, String usuario, String contraseña) {
        this.nombreCompleto = nombreCompleto;
        this.id           = id;
        this.telefono    = telefono;
        this.email         = email;
        this.edad          = edad;
        this.usuario         = usuario;
        this.contraseña = contraseña;


    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", id='" + id + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +

                '}';
    }
}
