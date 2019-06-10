package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaEntidades.Comentarios;

public class EscritorComentarios extends Escritor<Comentarios> {
    //private RepositorioComentarios repositorio = new RepositorioComentarios();
    public EscritorComentarios(int operacion, Comentarios comentarios) {
        super(operacion, comentarios);
    }

    public EscritorComentarios(int operacion, Comentarios comentarios, Comentarios entidadCambio) {
        super(operacion, comentarios, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            //return repositorio.alta(entidad);
            return false;

        if (operacion == OPERACION_BAJA)
            //return repositorio.baja(entidad.getIdDetalles());
            return false;
        if (operacion == OPERACION_CAMBIO)
            //return repositorio.cambio(entidad.getIdDetalles(),entidadCambio);
            return false;



        return false;
    }
}
