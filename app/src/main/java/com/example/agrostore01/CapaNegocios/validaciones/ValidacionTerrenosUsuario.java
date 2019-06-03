package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.TerrenosUsuario;

public class ValidacionTerrenosUsuario extends Validacion<TerrenosUsuario> {
    public ValidacionTerrenosUsuario(TerrenosUsuario terrenosUsuario) {
        super(terrenosUsuario);
    }
    public boolean validarIdTerreno(){
        if (entidad.getIdTerreno()==0)
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
     return validarIdTerreno() && validarIdUsuario();
    }
}
