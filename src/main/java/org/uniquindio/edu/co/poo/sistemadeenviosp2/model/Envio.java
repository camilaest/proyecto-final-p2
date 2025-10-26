package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Envio {
    private String idEnvio;
    private String direccionOrigen;
    private String direccionDestino;
    private long costo;
    private EstadoEnvio estadoEnvio;
    public Envio(Builder builder) {
        this.idEnvio = builder.idEnvio;
        this.direccionOrigen = builder.direccionOrigen;
        this.direccionDestino = builder.direccionDestino;
        this.costo = builder.costo;
        this.estadoEnvio = builder.estadoEnvio;
    }
    public static class Builder{
        private String idEnvio;
        private String direccionOrigen;
        private String direccionDestino;
        private long costo;
        private EstadoEnvio estadoEnvio;
        public Builder idEnvio(String idEnvio){
            this.idEnvio = idEnvio;
            return this;
        }
        public Builder direccionOrigen(String direccionOrigen){
            this.direccionOrigen = direccionOrigen;
            return this;
        }
        public Builder direccionDestino(String direccionDestino){
            this.direccionDestino = direccionDestino;
            return this;
        }
        public Builder costo(long costo){
            this.costo = costo;
            return this;
        }
        public Builder estadoEnvio(EstadoEnvio estadoEnvio){
            this.estadoEnvio = estadoEnvio;
            return this;
        }
        public Envio build(){
            return new Envio(this);
        }

    }

}
