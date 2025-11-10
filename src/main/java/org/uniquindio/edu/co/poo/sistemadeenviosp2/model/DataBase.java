package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Administrador> listaAdministrador;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Repartidor > listaRepartidores;
    private ArrayList<Envio> listaEnvios;
    private ArrayList<Direccion> listaDirecciones;
    private DataBase db;



    public DataBase() {
        this.listaAdministrador = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaRepartidores = new ArrayList<>();
        this.listaEnvios = new ArrayList<>();
        this.listaDirecciones = new ArrayList<>();
        inicializarDatos();
    }

    public DataBase getInstance(DataBase db){
        if(db == null){
            db = new DataBase();
        }
        return db;

    }

    public ArrayList<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }

    public void setListaAdministrador(Administrador administrador) {
        this.listaAdministrador.add(administrador);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Cliente cliente) {
        this.listaClientes.add(cliente);
    }

    public ArrayList<Repartidor> getListaRepartidores() {
        return listaRepartidores;
    }

    public void setListaRepartidores(Repartidor repartidor) {
        this.listaRepartidores.add(repartidor);
    }

    public ArrayList<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(Envio envio) {
        this.listaEnvios.add(envio);
    }

    public ArrayList<Direccion> getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(Direccion direccion) {
        this.listaDirecciones.add(direccion);
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
        Cliente cliente1 = new Cliente("Maria", "123", "3003", "maria@", 12, "mar", "77", TipoUsuario.CLIENTE, 100_000);
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

    public boolean actualizarRepartidor(String identificacion, Repartidor repartidorActualizar) {
        boolean centinela = false;
        for (Repartidor repartidor : listaRepartidores) {
            if (repartidor.getId().equals(identificacion)) {
                repartidor.setNombreCompleto(repartidorActualizar.getNombreCompleto());
                repartidor.setId(repartidorActualizar.getId());
                repartidor.setEmail(repartidorActualizar.getEmail());
                repartidor.setUsuario(repartidorActualizar.getUsuario());
                repartidor.setContraseña(repartidorActualizar.getContraseña());
                repartidor.setTelefono(repartidorActualizar.getTelefono());
                repartidor.setEdad(repartidorActualizar.getEdad());
                repartidor.setEnvio(repartidorActualizar.getEnvio());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    // CRUD ENVIO
    public boolean agregarEnvio(Envio envio) {
        boolean centinela = false;
        if (!verificarEnvio(envio.getIdEnvio())) {
            listaEnvios.add(envio);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarEnvio(String idEnvio) {
        boolean centinela = false;
        for (Envio envio : listaEnvios) {
            if (envio.getIdEnvio().equals(idEnvio)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean eliminarEnvio(String idEnvio) {
        boolean centinela = false;
        for (Envio envio : listaEnvios) {
            if (envio.getIdEnvio().equals(idEnvio)) {
                listaEnvios.remove(envio);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarEnvio(String idEnvio, Envio envioActualizar) {
        boolean centinela = false;
        for (Envio envio : listaEnvios) {
            if (envio.getIdEnvio().equals(idEnvio)) {
                envio.setIdEnvio(envioActualizar.getIdEnvio());
                envio.setDireccionOrigen(envioActualizar.getDireccionOrigen());
                envio.setDireccionDestino(envioActualizar.getDireccionDestino());
                envio.setCosto(envioActualizar.getCosto());
                envio.setEstadoEnvio(envioActualizar.getEstadoEnvio());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    // CRUD DIRECCION
    public boolean agregarDireccion(Direccion direccion) {
        boolean centinela = false;
        if (!verificarDireccion(direccion.getId())) {
            listaDirecciones.add(direccion);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarDireccion(String id) {
        boolean centinela = false;
        for (Direccion direccion : listaDirecciones) {
            if (direccion.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean eliminarDireccion(String id) {
        boolean centinela = false;
        for (Direccion direccion : listaDirecciones) {
            if (direccion.getId().equals(id)) {
                listaDirecciones.remove(direccion);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarDireccion(String id, Direccion direccionActualizar) {
        boolean centinela = false;
        for (Direccion direccion : listaDirecciones) {
            if (direccion.getId().equals(id)) {
                direccion.setId(direccionActualizar.getId());
                direccion.setOrigen(direccionActualizar.getOrigen());
                direccion.setDestino(direccionActualizar.getDestino());
                direccion.setAlias(direccionActualizar.getAlias());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

}
