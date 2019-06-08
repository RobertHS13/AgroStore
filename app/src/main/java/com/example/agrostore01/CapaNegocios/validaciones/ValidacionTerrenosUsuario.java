package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.TerrenosUsuario;

public class ValidacionTerrenosUsuario extends Validacion<TerrenosUsuario> {

    public ValidacionTerrenosUsuario(TerrenosUsuario terrenosUsuario) {
        super(terrenosUsuario);
    }

    public boolean validarIdTerreno(){
        System.out.println("Validating TerrenosUsuario.IdTerreno " + entidad.getIdTerreno() );
        if (entidad.getIdTerreno() <= -1)
            return false;

        return true;
    }
    public boolean validarIdUsuario(){
        System.out.println("Validating Terreno.IdUsuario " + entidad.getIdUsuario());
        if (entidad.getIdUsuario() == null)
            return false;

        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean validar() {
     return validarIdTerreno() && validarIdUsuario();
    }
}
