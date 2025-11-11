package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class Tarifa {
    public double valorPorDistancia;
    public double valorPorKg;
    public double valorPorVolumen;



    public Tarifa(double valorPorDistancia, double valorPorKg, double volumen) {
        this.valorPorDistancia = 1;
        this.valorPorKg = 5000;
        this.valorPorVolumen = 3000;

    }

    public Tarifa (){}

    public double getDistancia() {
        return valorPorDistancia;
    }

    public void setDistancia(double distancia) {
        this.valorPorDistancia = distancia;
    }

    public double getPeso() {
        return valorPorKg;
    }

    public void setPeso(double peso) {
        this.valorPorKg = peso;
    }

    public double getVolumen() {
        return valorPorVolumen;
    }

    public void setVolumen(double volumen) {
        this.valorPorVolumen = volumen;
    }



    public double calcularCosto(ArrayList<Paquete> listaPaquetes, double distanciaRecorrida) {
        double total = 0;

        for (Paquete paqueteAux : listaPaquetes) {
            double costoPorPeso = paqueteAux.getPeso() * valorPorKg;
            double costoPorVolumen = paqueteAux.getDimension() * valorPorVolumen;

            double costoPaquete = costoPorPeso + costoPorVolumen;
            total += costoPaquete;
        }

        double costoPorDistacia= valorPorDistancia*distanciaRecorrida;
        total+= costoPorDistacia;

        return total;
    }
}
