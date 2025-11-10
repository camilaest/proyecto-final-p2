package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.time.LocalDate;

public class Pago {
    private String idPago;
    private long monto;
    private LocalDate fechaPago;
    private MetodoDePago metodoDePago;
    public Pago(Builder builder){
        this.idPago = builder.idPago;
        this.monto = builder.monto;
        this.fechaPago = builder.fechaPago;
        this.metodoDePago = builder.metodoDePago;
    }
    public String getIdPago() {
        return idPago;
    }
    public long getMonto() {
        return monto;
    }
    public LocalDate getFechaPago() {
        return fechaPago;
    }
    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
    public void setMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }
    public void setMonto(long monto) {
        this.monto = monto;
    }

    public static class Builder{
        private String idPago;
        private long monto;
        private LocalDate fechaPago;
        private MetodoDePago metodoDePago;

        public Builder idPago(String idPago){
            this.idPago = idPago;
            return this;
        }
        public Builder monto(long monto){
            this.monto = monto;
            return this;
        }
        public Builder fechaPago(LocalDate fechaPago){
            this.fechaPago = fechaPago;
            return this;
        }
        public Builder metodoDePago(MetodoDePago metodoDePago){
            this.metodoDePago = metodoDePago;
            return this;
        }
        public Pago build(){
            return new Pago(this);
        }

    }
}
