package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Administrador> listaAdministrador;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Repartidor > listaRepartidores;
    private ArrayList<Envio> listaEnvios;
    private DataBase db;



    public DataBase() {
        this.listaUsuarios = new ArrayList<>();
        this.listaAdministrador = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaRepartidores = new ArrayList<>();
        this.listaEnvios = new ArrayList<>();
        inicializarDatos();
    }

    public DataBase getInstance(DataBase db){
        if(db == null){
            db = new DataBase();
        }
        return db;

    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }

    public void setListaAdministrador(ArrayList<Administrador> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Repartidor> getListaRepartidores() {
        return listaRepartidores;
    }

    public void setListaRepartidores(ArrayList<Repartidor> listaRepartidores) {
        this.listaRepartidores = listaRepartidores;
    }

    public ArrayList<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(ArrayList<Envio> listaEnvios) {
        this.listaEnvios = listaEnvios;
    }

    //CRUD CLIENTE
    public boolean agregarCliente(Cliente cliente ) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getId())) {
            listaClientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarCliente(String identificacion) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean eliminarCliente(String id) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(id)) {
                listaClientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String identificacion, Cliente clienteActualizar) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(identificacion)) {
                cliente.setNombreCompleto(clienteActualizar.getNombreCompleto());
                cliente.setId(clienteActualizar.getId());
                cliente.setEmail(clienteActualizar.getEmail());
                cliente.setUsuario(clienteActualizar.getUsuario());
                cliente.setContraseña(clienteActualizar.getContraseña());
                cliente.setTelefono(clienteActualizar.getTelefono());
                cliente.setEdad(clienteActualizar.getEdad());

                centinela = true;
                break;
            }
        }
        return centinela;
    }

    private void inicializarDatos(){
        Cliente cliente1 = new Cliente("Maria", "123", "3003", "maria@", 12, "mar", "77", TipoUsuario.CLIENTE);
        listaClientes.add(cliente1);

        Administrador admin1 = new Administrador("Maria", "123", "3003", "maria@", 12, "mariaest", "88", TipoUsuario.ADMINISTRADOR);
        listaAdministrador.add(admin1);


    }

    //CRUD ADMIN
    public boolean agregarAdmin(Administrador admin ) {
        boolean centinela = false;
        if (!verificarAdministrador(admin.getId())) {
            listaAdministrador.add(admin);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarAdministrador(String identificacion) {
        boolean centinela = false;
        for (Administrador administrador : listaAdministrador) {
            if (administrador.getId().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }


}
