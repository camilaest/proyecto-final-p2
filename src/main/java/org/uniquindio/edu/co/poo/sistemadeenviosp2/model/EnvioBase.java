package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class EnvioBase implements IEnvio {
    private String idEnvio;
    private Tarifa tarifa;
    private EstadoEnvio estadoEnvio;
    private ArrayList<Paquete> listaPaquetes;


    public EnvioBase(String idEnvio,  Tarifa tarifa, ArrayList<Paquete> listaPaquetes) {
        this.idEnvio = idEnvio;
        this.estadoEnvio= EstadoEnvio.ASIGNADO; //luego se setea
        this.tarifa = tarifa;
        this.estadoEnvio = estadoEnvio;
        this.listaPaquetes = listaPaquetes;
    }





    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    @Override
    public double calcularCosto() {

        return tarifa.calcularCosto(listaPaquetes);
    }

    @Override
    public String getDescripcion() {
        return "Envío estándar";
    }

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(ArrayList<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }
}
