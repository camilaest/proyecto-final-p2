package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class EnvioConPrioridad extends EnvioDecorador {

    public EnvioConPrioridad(IEnvio envioDecorado) {
        super(envioDecorado);
    }

    @Override
    public double calcularCosto() {

        return super.calcularCosto() * 1.2;

    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Prioridad";
    }

}
