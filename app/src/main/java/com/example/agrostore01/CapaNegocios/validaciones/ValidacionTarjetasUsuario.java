package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.TarjetasUsuario;

public class ValidacionTarjetasUsuario extends Validacion<TarjetasUsuario> {

    public ValidacionTarjetasUsuario(TarjetasUsuario tarjetasUsuario) {
        super(tarjetasUsuario);
    }

    public boolean validarNumTarjeta(){
        System.out.println("Validating TarjetasUsuario.NumTarjeta " + entidad.getNumTarjeta());
        if (entidad.getNumTarjeta() == null)
            return false;

        if (entidad.getNumTarjeta().isEmpty())
            return false;

        return true ;
    }
    public boolean validarIdUsuario(){
        //da' id is string , check this out
        System.out.println("Validating TarjetasUsuario.IdUsuario " + entidad.getIdUsuario());
        if (entidad.getIdUsuario() == null)
            return  false;

        if (entidad.getIdUsuario().isEmpty())
            return false;

        return true ;
    }

    @Override
    public boolean validar() {
        return validarNumTarjeta() && validarIdUsuario();
    }
}
