package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class Cliente extends Usuario {
    private ArrayList<Direccion> direcciones;
    private ArrayList<Pago> pagos;
    private long monto; // saldo del cliente
    public Cliente(String nombreCompleto, String id, String telefono, String email, int edad, String usuarioSesion, String contraseña, TipoUsuario tipoUsuario, long monto) {
        super(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, tipoUsuario);
        this.direcciones = new ArrayList<>();
        this.pagos = new ArrayList<>();
        this.monto = monto;
    }
    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    public ArrayList<Pago> getPagos(){
        return pagos;
    }

    public long getMonto() {
        return monto;
    }
    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String consignar(long valor){
        if (valor <= 0) return "Valor inválido";
        this.monto += valor;
        return "Consignación exitosa";
    }

    private long calcularTributos(long base, MetodoDePago metodo){
        // Reglas simples de tributos
        switch (metodo){
            case TARJETA_DE_CREDITO:
                return Math.round(base * 0.03); // 3%
            case TARJETA_DE_DEBITO:
                return Math.round(base * 0.015); // 1.5%
            case EFECTIVO:
            default:
                return 0L;
        }
    }

    public String realizarPago(Pago pago){
        Empresa empresa = Empresa.getInstance();
        long total = pago.getTotal();
        if(this.monto >= total){
            this.monto -= total;
            empresa.setMonto(empresa.getMonto() + total);
            // Registrar pago
            pagos.add(pago);
            return "Pago realizado con éxito";
        }else{
            return "Saldo insuficiente";
        }
    }

    // Helper para construir pago con tributos según método
    public Pago construirPago(long base, MetodoDePago metodo){
        long tributos = calcularTributos(base, metodo);
        Pago p = new Pago.Builder()
                .monto(base)
                .tributos(tributos)
                .metodoDePago(metodo)
                .build();
        return p;
    }
}
