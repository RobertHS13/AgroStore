package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.TipoUsuario;

public class ValidacionTipoUsuario extends Validacion<TipoUsuario> {
    public ValidacionTipoUsuario(TipoUsuario tipoUsuario) {
        super(tipoUsuario);
    }
    public boolean validarTipoUsuario(){
        if (entidad.getTipoUsuario().isEmpty())
            return false;
        return true;
    }
    public boolean validarIdTipo(){
        if (entidad.getIdTipo()==0)
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdTipo() && validarTipoUsuario();
    }
}
