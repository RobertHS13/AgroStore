package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Empresa;

public class ValidacionEmpresa extends Validacion<Empresa> {
    public ValidacionEmpresa(Empresa empresa) {
        super(empresa);
    }
    /*
    *   private int idEmpresa;
    private String nombre;
    private String direccion;
    private String numTelefono;
    private String correo;
    * */

    public boolean validarIdEmpresa(){
        if (entidad.getIdEmpresa()==1)
            return false;

        return true;
    }
    public boolean validarCorreo(){
        if (entidad.getCorreo().isEmpty())
            return  false;
        return true;
    }

    public boolean validarNombre(){
        if (entidad.getNombre().isEmpty())
            return false;

        return true;
    }
    public boolean validarDireccion (){
        if (entidad.getDireccion().isEmpty())
            return false;
        return true;
    }

    public boolean validarNumTelefono(){
        if (entidad.getNumTelefono().isEmpty())
            return false;
        try{
            Long validarNum= Long.parseLong(entidad.getNumTelefono());

        }catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean validar() {

        return validarIdEmpresa() && validarNombre() && validarDireccion() && validarNumTelefono() && validarCorreo();

    }


}
