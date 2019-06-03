package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Tarjetas;

public class ValidacionTarjetas extends Validacion<Tarjetas>  {
    /*    private String numTarjeta;
    private String cdv;
    private String mes;
    private String año;*/


    public ValidacionTarjetas(Tarjetas tarjetas) {
        super(tarjetas);
    }

    @Override
    public boolean validar() {
        return validarNumTarjeta() && validarCdv() && validarMes() && validarAno();
    }
    public boolean validarNumTarjeta(){
        if (entidad.getNumTarjeta().isEmpty())
            return false;
        return true ;
    }
    public boolean validarCdv(){
        if (entidad.getCdv().isEmpty())
            return false;
        return true;
    }
    public boolean validarMes(){
        if (entidad.getMes().isEmpty())
            return false;
        return true ;
    }
    public boolean validarAno(){
        if (entidad.getAño().isEmpty())
            return false;
        return true ;
    }
}
