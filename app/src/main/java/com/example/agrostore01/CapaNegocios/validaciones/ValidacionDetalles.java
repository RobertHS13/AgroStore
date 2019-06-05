package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.DetallesUsuario;

public class ValidacionDetalles extends Validacion <DetallesUsuario> {

    public ValidacionDetalles(DetallesUsuario detallesUsuario) {
        super(detallesUsuario);
    }

    @Override
    public boolean validar() {
        return validarIdDetalles() && validarCalle() && validarColonia() &&validarCiudad() &&validarEstado() && validarPais() && validarCp() && validarEscrituraOPermiso() && validarEstrellas() && validarRfc()&& validarFirmaElectronica()&&validarNombres()&&validarApellidos();

        //return false;
    }
    public boolean validarIdDetalles(){
        if (entidad.getIdDetalles() == 0)
            return false;
        return  true;
    }
    public boolean validarCalle() {
        if (entidad.getCalle().isEmpty())
            return false;
        return true;
    }
    public boolean validarCiudad(){
        if (entidad.getCuidad().isEmpty())
            return false;
        return true;
    }
    public boolean validarColonia(){
        if (entidad.getColonia().isEmpty())
            return false;
        return true;
    }
    public boolean validarPais(){
        if (entidad.getPais().isEmpty())
            return false;
        return true;
    }
    public boolean validarEstado(){
        if (entidad.getEstado().isEmpty())
            return false;
        return true;
    }
    public boolean validarCp(){
        if (entidad.getCp()==0)
            return false;
        return true;
    }
    public boolean validarEscrituraOPermiso(){
        if (entidad.getEscrituraOPermiso().isEmpty())
            return false;
        return true;
    }
    public boolean validarApellidos(){
        if (entidad.getApellidos().isEmpty())
            return false;
        return true;
    }
    public boolean validarEstrellas(){
        if (entidad.getEstrellas()==0)
            return false;

        return true;
    }
    public boolean validarNombres(){
        if (entidad.getNombres().isEmpty())
            return false;
        return true;
    }
    public boolean validarFirmaElectronica(){
        if (entidad.getFirmaElectronica().isEmpty())
            return false;
        return true;
    }
    public boolean validarRfc(){
        if (entidad.getRfc().isEmpty())
            return false;
        return true;
    }
}
