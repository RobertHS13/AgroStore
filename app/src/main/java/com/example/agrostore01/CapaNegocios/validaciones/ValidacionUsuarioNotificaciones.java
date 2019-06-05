package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.UsuarioNotificaciones;

public class ValidacionUsuarioNotificaciones extends Validacion<UsuarioNotificaciones> {
    public ValidacionUsuarioNotificaciones(UsuarioNotificaciones usuarioNotificaciones) {
        super(usuarioNotificaciones);
    }
    public boolean validarIdNotificacion(){
        if (entidad.getIdNotificacion()==0)
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
        return validarIdUsuario() && validarIdNotificacion();
    }
}
