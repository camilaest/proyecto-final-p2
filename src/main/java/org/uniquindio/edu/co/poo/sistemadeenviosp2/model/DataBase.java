package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Administrador> listaAdministrador;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Repartidor > listaRepartidores;
    private ArrayList<EnvioBase> listaEnvios;
    private DataBase db;
    private Tarifa tarifa;



    public DataBase() {
        this.listaUsuarios = new ArrayList<>();
        this.listaAdministrador = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaRepartidores = new ArrayList<>();
        this.listaEnvios = new ArrayList<>();
        this.tarifa= new Tarifa (1,2,3);
        inicializarDatos();
    }

    public DataBase getInstance(DataBase db){
        if(db == null){
            db = new DataBase();
        }
        return db;

    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
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

    public ArrayList<EnvioBase> getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(ArrayList<EnvioBase> listaEnvios) {
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

        Repartidor repartidor = new Repartidor("Claudia", "41871", "311401", "Claudia@est.com", 34, "claudia00", "33", TipoUsuario.REPARTIDOR, "repartidor1");
        listaRepartidores.add(repartidor);
        repartidor.setDisponibilidad(Disponibilidad.INACTIVO);


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

    //CRUD REPARTIDOR

    public boolean agregarRepartidor(Repartidor repartidor) {
        boolean centinela = false;
        if (!verificarRepartidor(repartidor.getId())) {
            listaRepartidores.add(repartidor);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarRepartidor(String identificacion) {
        boolean centinela = false;
        for (Repartidor repartidor : listaRepartidores) {
            if (repartidor.getId().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean actualizarRepartidor(String identificacion, Repartidor repartidorActualizar) {
        boolean centinela = false;
        for (Repartidor repartidor : listaRepartidores) {
            if (repartidor.getId().equals(identificacion)) {
                repartidor.setNombreCompleto(repartidorActualizar.getNombreCompleto());
                repartidor.setId(repartidorActualizar.getId());
                repartidor.setEmail(repartidorActualizar.getEmail());
                repartidor.setTelefono(repartidorActualizar.getTelefono());
                repartidor.setEdad(repartidorActualizar.getEdad());
                repartidor.setIdRepartidor(repartidorActualizar.getIdRepartidor());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean eliminarRepartidor(String id) {
        boolean centinela = false;
        for (Repartidor repartidor : listaRepartidores) {
            if (repartidor.getId().equals(id)) {
                listaRepartidores.remove(repartidor);
                centinela = true;
                break;
            }
        }
        return centinela;
    }



    //CRUD DE ENVIO


    public boolean agregarEnvio(EnvioBase envio) {
        boolean centinela = false;
        if (!verificarEnvio(envio.getIdEnvio())) {
            listaEnvios.add(envio);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarEnvio(String identificacion) {
        boolean centinela = false;
        for (EnvioBase base : listaEnvios) {
            if (base.getIdEnvio().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }



}
