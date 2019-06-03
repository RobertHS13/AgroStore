package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Notificaciones;

public class ValidacionNotificaciones extends Validacion<Notificaciones> {

    public ValidacionNotificaciones(Notificaciones notificaciones) {
        super(notificaciones);
    }

    public boolean validarDetalle(){
        if (entidad.getDetalle().isEmpty())
            return false;
        return true;
    }
    public boolean validarIdNotificacion(){
        if (entidad.getIdNotificacion()==0)
            return false;
        return true;
    }

    @Override
    public boolean validar() {
        return  validarIdNotificacion() && validarDetalle();
    }
}
