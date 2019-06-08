package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Historial;

public class ValidacionHistorial extends Validacion<Historial> {
    public ValidacionHistorial(Historial historial) {
        super(historial);
    }

    public boolean validarIdHistorial(){
        System.out.println("Validating Historial.IdHistorial "+ entidad.getIdHistorial());
        if (entidad.getIdHistorial()<=-1){
            return false;
        }
        return true;
    }
    public boolean validarIdUsuario(){
        System.out.println("Validating Historial.IdUsuario "+entidad.getIdUsuario());

        if (entidad.getIdUsuario() == null)
            return false;

        if (entidad.getIdUsuario().isEmpty())
            return false;

        return true;
    }
    public boolean validarBusqueda(){
        System.out.println("Validating Historial.Busqueda "+entidad.getBusqueda());

        if (entidad.getBusqueda() == null )
            return false;

        if (entidad.getBusqueda().isEmpty())
            return false;

        return true;
    }

    @Override
    public boolean validar() {
        return validarIdHistorial() && validarIdUsuario() && validarBusqueda();
    }
}
