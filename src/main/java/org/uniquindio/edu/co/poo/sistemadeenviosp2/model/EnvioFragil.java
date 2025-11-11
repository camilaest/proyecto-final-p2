package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class EnvioFragil extends EnvioDecorador {

    public EnvioFragil(IEnvio envioDecorado) {
        super(envioDecorado);
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() +2000; // 20% más caro
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Con cuidado, es Fragil";
    }
}
