package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Paquete {

    public double peso;
    public double dimension;
    public double valorDeclarado;

    public Paquete(double peso, double dimension, double valorDeclarado) {
        this.peso = peso;
        this.dimension = dimension;
        this.valorDeclarado = valorDeclarado;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDimension() {
        return dimension;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "peso=" + peso +
                ", dimension=" + dimension +
                ", valorDeclarado=" + valorDeclarado +
                '}';
    }
}
