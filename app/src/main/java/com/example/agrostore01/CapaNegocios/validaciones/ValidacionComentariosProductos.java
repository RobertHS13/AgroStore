package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.ComentariosProductos;

public class ValidacionComentariosProductos extends Validacion<ComentariosProductos> {
    public ValidacionComentariosProductos(ComentariosProductos comentariosProductos) {
        super(comentariosProductos);
    }
    public boolean validarIdComentarios(){
        System.out.println("Validating ComentariosProductos.IdComentarios "+ entidad.getIdComentarios());
        if (entidad.getIdComentarios() <=-1)
            return false;
        return true;
    }

    public boolean validarIdProductoTerreno(){
        System.out.println("Validating ComentariosProductos.IdProductoTerreno "+ entidad.getIdProductoTerreno());
        if (entidad.getIdProductoTerreno() <=-1)
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdComentarios() && validarIdProductoTerreno();
    }
}
