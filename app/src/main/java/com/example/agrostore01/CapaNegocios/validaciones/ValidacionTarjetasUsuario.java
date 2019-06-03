package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.TarjetasUsuario;

public class ValidacionTarjetasUsuario extends Validacion<TarjetasUsuario> {
    /*  private String numTarjeta;
    private String idUsuario;
*/
    public ValidacionTarjetasUsuario(TarjetasUsuario tarjetasUsuario) {
        super(tarjetasUsuario);
    }


    public boolean validarNumTarjeta(){
        if (entidad.getNumTarjeta().isEmpty())
            return false;
        return true ;
    }
    public boolean validarIdUsuario(){
        //da' id is string , check this out
        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true ;
    }
    @Override
    public boolean validar() {

        return validarNumTarjeta() && validarIdUsuario();
    }
}
