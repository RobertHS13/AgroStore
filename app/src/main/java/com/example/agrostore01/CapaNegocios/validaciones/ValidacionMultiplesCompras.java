package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.MultiplesCompras;

public class ValidacionMultiplesCompras extends  Validacion<MultiplesCompras> {
    public ValidacionMultiplesCompras(MultiplesCompras multiplesCompras) {
        super(multiplesCompras);
    }
    public boolean validarIdCar(){
        if (entidad.getIdCar()==0)
            return false;
        return true;
    }
    public boolean validarIdNumProducto(){
        if (entidad.getIdNumProducto()==0)
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdCar() && validarIdNumProducto();
    }
}
