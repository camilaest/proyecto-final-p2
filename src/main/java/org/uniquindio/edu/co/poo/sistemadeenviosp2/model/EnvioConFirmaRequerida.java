package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class EnvioConFirmaRequerida extends EnvioDecorador{

    public EnvioConFirmaRequerida(IEnvio envioDecorado) {
        super(envioDecorado);
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() +1000;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Con firma requerida";
    }


}
