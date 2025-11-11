package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class EnvioConSeguro extends EnvioDecorador {

    public EnvioConSeguro(IEnvio envioDecorado) {
        super(envioDecorado);
    }

    @Override
    public double calcularCosto() {
        double valorDeclaradoTotal = 0;
        if (envioDecorado instanceof EnvioBase base) {
            for (Paquete p : base.getListaPaquetes()) {
                valorDeclaradoTotal += p.getValorDeclarado();
            }
        }
        return super.calcularCosto() + valorDeclaradoTotal * 0.02;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Seguro";
    }


}
