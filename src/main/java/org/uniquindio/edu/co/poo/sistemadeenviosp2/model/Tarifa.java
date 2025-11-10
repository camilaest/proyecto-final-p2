package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Tarifa {
    public double distancia;
    public double peso;
    public double volumen;
    public boolean prioridad;


    public Tarifa(double distancia, double peso, double volumen, boolean prioridad) {
        this.distancia = 0;
        this.peso = peso;
        this.volumen = volumen;
        this.prioridad = prioridad;
    }

    public Tarifa (){}

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public double calcularCostoEstimado (double distanciaEnvio, double pesoEnvio, double volumenEnvio, boolean prioridadEnvio   ){
        distancia = 1000;
        peso = 5000;
        volumen =2000;
        double prioridadValor =0;
        double valorDistancia =0;
        double valorPeso =0;
        double valorVolumen =0;
        double valorTotal =0;
        if (prioridadEnvio == true){
            prioridadValor = 10000;
        }
        valorDistancia = distanciaEnvio * distancia;
        valorPeso = pesoEnvio * peso;
        valorVolumen = volumenEnvio * volumen;
        valorTotal = valorDistancia + valorPeso + valorVolumen + prioridadValor;
        return valorTotal;

    }
}
