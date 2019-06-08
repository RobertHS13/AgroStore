package com.example.agrostore01.CapaNegocios.escritores;

public abstract class Escritor<Entidad> {

    public static int OPERACION_ALTA = 1;
    public static int OPERACION_BAJA = 2;
    public static int OPERACION_CAMBIO = 3;

    protected int operacion;
    protected Entidad entidad;
    protected Entidad entidadCambio;

    public Escritor(int operacion,Entidad entidad){
        this.operacion = operacion;
        this.entidad = entidad;
    }

    public Escritor(int operacion, Entidad entidad, Entidad entidadCambio) {
        this.operacion = operacion;
        this.entidad = entidad;
        this.entidadCambio = entidadCambio;
    }

    public abstract boolean ejecutarCambios();
}
