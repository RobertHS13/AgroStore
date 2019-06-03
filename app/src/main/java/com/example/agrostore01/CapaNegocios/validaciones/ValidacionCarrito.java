package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Carrito;

public class ValidacionCarrito extends Validacion<Carrito> {
    public ValidacionCarrito(Carrito carrito) {
        super(carrito);
    }
    public boolean validarIdCar(){
        if (entidad.getIdCar()==0)
            return false;
        return true;
    }
    public boolean validarIdUsuario(){
        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdCar() && validarIdUsuario();
    }
}
