package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Carrito;

public class ValidacionCarrito extends Validacion<Carrito> {
    public ValidacionCarrito(Carrito carrito) {
        super(carrito);
    }

    public boolean validarIdCar(){
        System.out.println("Validationg Carrito.IdCar "+ entidad.getIdCar());

        if (entidad.getIdCar() <= -1)
            return false;

        return true;
    }
    public boolean validarIdUsuario(){
        System.out.println("Validating Carrito.IdUsuario " + entidad.getIdUsuario());

        if(entidad.getIdUsuario() == null)
            return false;

        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdCar() && validarIdUsuario();
    }
}
