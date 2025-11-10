package org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

import java.util.ArrayList;

public class Cliente extends Usuario {
    private ArrayList<Direccion> direcciones;
    private long monto;
    public Cliente(String nombreCompleto, String id, String telefono, String email, int edad, String usuarioSesion, String contraseña, TipoUsuario tipoUsuario, long monto) {
        super(nombreCompleto, id, telefono, email, edad, usuarioSesion, contraseña, tipoUsuario);
        this.direcciones = new ArrayList<>();
        this.monto = monto;
    }
    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    public long getMonto() {
        return monto;
    }
    public void setMonto(long monto) {
        this.monto = monto;
    }
    public String realizarPago(Pago pago){
        Empresa empresa = Empresa.getInstance();
        if(pago.getMonto() >= this.monto){
            this.monto -= pago.getMonto();
            empresa.setMonto(empresa.getMonto() + pago.getMonto());
            return "Pago realizado con exito";
        }else{
            return "El monto a pagar no es suficiente";
        }
    }

}
