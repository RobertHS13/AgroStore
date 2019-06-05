package com.example.agrostore01.CapaNegocios.escritores;

public abstract class EscritorRelacion <Entidad> extends Escritor<Entidad>{

    public static int OPERACION_BAJA_ESPECIFICA = 4;


    public EscritorRelacion(int operacion, Entidad entidad) {
        super(operacion, entidad);
    }

    public EscritorRelacion(int operacion, Entidad entidad, Entidad entidadCambio) {
        super(operacion, entidad, entidadCambio);
    }
}
