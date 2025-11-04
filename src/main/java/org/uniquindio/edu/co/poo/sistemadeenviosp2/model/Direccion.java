package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

public class Direccion {
    private String origen;
    private String destino;
    private String id;
    private String alias;
    private String calle;
    private String coordenadas;
    private String ciudad;
    public Direccion(Builder builder){
        this.origen = builder.origen;
        this.destino = builder.destino;
        this.id = builder.id;
        this.alias = builder.alias;
        this.calle = builder.calle;
        this.coordenadas = builder.coordenadas;
        this.ciudad = builder.ciudad;
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
    public String getCalle() {
        return calle;
    }
    public String getCoordenadas() {
        return coordenadas;
    }
    public String getCiudad() {
        return ciudad;
    }

    public static class Builder{
        private String origen;
        private String destino;
        private String id;
        private String alias;
        private String calle;
        private String coordenadas;
        private String ciudad;
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

        public Builder calle(String calle){
            this.calle = calle;
            return this;
        }
        public Builder coordenadas(String coordenadas){
            this.coordenadas = coordenadas;
            return this;
        }

        public Builder ciudad(String ciudad){
            this.ciudad = ciudad;
            return this;
        }
        public Direccion build(){
            return new Direccion(this);
        }
    }


}
