package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Usuario;

public class ValidacionUsuario extends Validacion<Usuario> {

    public ValidacionUsuario(Usuario usuario) {
        super(usuario);
    }

    public boolean validarIdUsuario(){
        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true ;
    }
    public boolean validarContrasenaUsuario(){
        if (entidad.getContrasenaUsuario().isEmpty())
            return false;
        return true ;
    }
    public boolean validarIdTipo(){
        if (entidad.getIdTipo()==0)
            return false;
        return true ;
    }
    public boolean validarIdDetalles(){
        if (entidad.getIdDetalles()==0)
            return false;
        return true ;
    }
    public boolean validarFoto(){
        if (entidad.getFoto().length==0)
            return false;
        return true ;
    }
    public boolean validarCorreo(){
        if (entidad.getCorreo().isEmpty())
            return false;
        return true ;
    }
    @Override
    public boolean validar() {
        return validarIdUsuario() && validarContrasenaUsuario() && validarIdTipo() && validarIdDetalles() && validarFoto() && validarCorreo();

    }
}
