package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Notificaciones;

public class ValidacionNotificaciones extends Validacion<Notificaciones> {

    public ValidacionNotificaciones(Notificaciones notificaciones) {
        super(notificaciones);
    }

    public boolean validarDetalle(){
        System.out.println("Validating Notificaciones.Detalle " + entidad.getDetalle());

        if (entidad.getDetalle() == null)
            return false;

        if (entidad.getDetalle().isEmpty())
            return false;

        return true;
    }
    public boolean validarIdNotificacion(){
        System.out.println("Validating Notificaciones.IdNotificacion " + entidad.getIdNotificacion());
        if (entidad.getIdNotificacion()<=-1)
            return false;
        return true;
    }

    @Override
    public boolean validar() {
        return  validarIdNotificacion() && validarDetalle();
    }
}
