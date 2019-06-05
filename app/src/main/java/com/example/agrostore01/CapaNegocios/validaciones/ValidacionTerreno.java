package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Terreno;

public class ValidacionTerreno extends Validacion<Terreno> {
    public ValidacionTerreno(Terreno terreno) {
        super(terreno);
    }
    public boolean validarIdTerreno(){
        if (entidad.getIdTerreno()==0)
            return false;
        return true;
    }
    public boolean validarMedida(){
        if (entidad.getMedida().isEmpty())
            return false;
        return true;
    }
    public boolean validarTamano(){
        if (entidad.getTamaño()==0)
            return false;
        return true;
    }
    public boolean validarTipo(){
        if (entidad.getTipo().isEmpty())
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdTerreno() && validarMedida() && validarTamano() && validarTipo();
    }
}
