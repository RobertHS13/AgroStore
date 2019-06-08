package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.MultiplesCompras;

public class ValidacionMultiplesCompras extends  Validacion<MultiplesCompras> {
    public ValidacionMultiplesCompras(MultiplesCompras multiplesCompras) {
        super(multiplesCompras);
    }

    public boolean validarIdCar(){
        System.out.println("Validating MultiplesCompras.IdCar "+entidad.getIdCar());
        if (entidad.getIdCar()<=-1)
            return false;

        return true;
    }
    public boolean validarIdNumProducto(){
        System.out.println("Validating EmpresaCertificados.IdNumProducto "+ entidad.getIdNumProducto());
        if (entidad.getIdNumProducto()<=-1)
            return false;

        return true;
    }

    @Override
    public boolean validar() {
        return validarIdCar() && validarIdNumProducto();
    }
}
