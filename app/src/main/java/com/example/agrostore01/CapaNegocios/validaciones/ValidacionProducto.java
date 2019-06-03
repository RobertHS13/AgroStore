package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Producto;

public class ValidacionProducto extends Validacion<Producto> {
    public ValidacionProducto(Producto producto) {
        super(producto);
    }

    public boolean validarFoto(){
        if (entidad.getFoto().length==0)
            return false;
        return true;
    }
    public boolean validarIdProducto(){
        if (entidad.getIdProducto()==0)
            return false;
        return true;
    }
    public boolean validarIdCategoria(){
        if (entidad.getIdCategoria()==0)
            return false;
        return true;
    }
    public boolean validarPrecioKilogramo(){
        if (entidad.getPrecioKilogramo().longValue()==0)
            return false;
        return true;
    }
    public boolean validarPrecioTonelada(){
        if (entidad.getPrecioTonelada().longValue()==0)
            return false;
        return true;
    }
    public boolean validarProducto(){
        if (entidad.getProducto().isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean validar() {
        return validarIdProducto() && validarIdCategoria() && validarProducto() && validarFoto() && validarPrecioKilogramo() && validarPrecioTonelada();
    }
}
