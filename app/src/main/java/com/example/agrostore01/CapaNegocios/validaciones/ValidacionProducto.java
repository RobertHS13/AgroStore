package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Producto;

import java.util.Arrays;

public class ValidacionProducto extends Validacion<Producto> {
    public ValidacionProducto(Producto producto) {
        super(producto);
    }

    public boolean validarFoto(){
        System.out.println("Validating Producto.Foto " + Arrays.toString(entidad.getFoto()));
        return true;
    }
    public boolean validarIdProducto(){
        System.out.println("Validating Producto.IdProducto " + entidad.getIdProducto());
        if (entidad.getIdProducto()<=-1)
            return false;
        return true;
    }
    public boolean validarIdCategoria(){
        System.out.println("Validating Producto.IdCategoria " +entidad.getIdCategoria());
        if (entidad.getIdCategoria()<=-1)
            return false;

        return true;
    }
    public boolean validarPrecioKilogramo(){
        System.out.println("Validating Producto.PrecioKilogramo " + entidad.getPrecioKilogramo());

        if (entidad.getPrecioKilogramo().longValue()==0)
            return false;

        return true;
    }
    public boolean validarPrecioTonelada(){
        System.out.println("Validating Producto.PrecioTonelada " +entidad.getPrecioTonelada());

        if (entidad.getPrecioTonelada().longValue()==0)
            return false;

        return true;
    }
    public boolean validarProducto(){
        System.out.println("Validating Producto.Producto " +entidad.getProducto());
        if (entidad.getProducto() == null)
            return false;

        if (entidad.getProducto().isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean validar() {
        return validarIdProducto() && validarIdCategoria() && validarProducto() && validarFoto() && validarPrecioKilogramo() && validarPrecioTonelada();
    }
}
