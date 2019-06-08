package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Tarjetas;

public class ValidacionTarjetas extends Validacion<Tarjetas>  {

    public ValidacionTarjetas(Tarjetas tarjetas) {
        super(tarjetas);
    }

    @Override
    public boolean validar() {
        return validarNumTarjeta() && validarCdv() && validarMes() && validarAno();
    }

    public boolean validarNumTarjeta(){
        System.out.println("Validating Tarjetas.NumTarjeta " + entidad.getNumTarjeta());

        if (entidad.getNumTarjeta() == null)
            return  false;

        if (entidad.getNumTarjeta().isEmpty())
            return false;

        return true ;
    }
    public boolean validarCdv(){
        System.out.println("Validating Tarjetas.Cdv " + entidad.getCdv());

        if (entidad.getCdv() == null)
            return false;

        if (entidad.getCdv().isEmpty())
            return false;

        return true;
    }
    public boolean validarMes(){
        System.out.println("Validating Tarjetas.Mes " + entidad.getMes());
        if (entidad.getMes() == null)
            return false;

        if (entidad.getMes().isEmpty())
            return false;
        return true ;
    }
    public boolean validarAno(){
        System.out.println("Validating Tarjetas.Ano "+ entidad.getAño() );

        if (entidad.getAño() == null )
            return false;

        if (entidad.getAño().isEmpty())
            return false;
        return true ;
    }

}
