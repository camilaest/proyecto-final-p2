package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Direccion {
    private String origen;
    private String destino;
    private String id;
    private String alias;
    public Direccion(Builder builder){
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.id = builder.id;
        this.alias = builder.alias;
    }

    public String getAlias() {
        return alias;
    }
    public String getId() {
        return id;
    }
    public String getOrigen() {
        return origen;
    }
    public String getDestino() {
        return destino;
    }

    public static class Builder{
        private String origen;
        private String destino;
        private String id;
        private String alias;
        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder origen(String origen){
            this.origen = origen;
            return this;
        }
        public Builder destino(String destino){
            this.destino = destino;
            return this;
        }
        public Builder alias(String alias){
            this.alias = alias;
            return this;
        }
        public Direccion build(){
            return new Direccion(this);
        }
    }


}
