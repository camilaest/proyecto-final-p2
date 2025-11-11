package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public abstract class EnvioDecorador implements IEnvio {
    protected IEnvio envioDecorado;

    public EnvioDecorador(IEnvio envioDecorado) {
        this.envioDecorado = envioDecorado;
    }

    @Override
    public double calcularCosto() {

        return envioDecorado.calcularCosto();
    }

    @Override
    public String getDescripcion() {
        return envioDecorado.getDescripcion();
    }


}
