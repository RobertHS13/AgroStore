package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaEntidades.ComentariosProductos;

public class EscritorComentariosProductos extends Escritor<ComentariosProductos> {
    //private RepositoComentariosProducto repositorio = new RepositoriosComentariosProductos();
    public EscritorComentariosProductos(int operacion, ComentariosProductos comentariosProductos) {
        super(operacion, comentariosProductos);
    }

    public EscritorComentariosProductos(int operacion, ComentariosProductos comentariosProductos, ComentariosProductos entidadCambio) {
        super(operacion, comentariosProductos, entidadCambio);
    }


    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            return true;
            //return repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            //return repositorio.baja(entidad.getIdProductoComprado())
            return true;

        if (operacion == OPERACION_CAMBIO)
            //return repositorio.cambio(entidad,entidadCambio);
            return true;





        return false;
    }
}
