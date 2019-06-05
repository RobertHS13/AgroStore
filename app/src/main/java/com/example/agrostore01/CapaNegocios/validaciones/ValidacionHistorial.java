package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Historial;

public class ValidacionHistorial extends Validacion<Historial> {
    public ValidacionHistorial(Historial historial) {
        super(historial);
    }
    public boolean validarIdHistorial(){
        if (entidad.getIdHistorial()==0){
            return false;
        }
        return true;
    }
    public boolean validarIdUsuario(){
        if (entidad.getIdUsuario().isEmpty()) {
            return false;
        }
        return true;
    }
    public boolean validarIdBusqueda(){
        if (entidad.getBusqueda().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validar() {
        return validarIdHistorial() && validarIdUsuario() && validarIdBusqueda();
    }
}
