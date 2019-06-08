package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Empresa;

public class ValidacionEmpresa extends Validacion<Empresa> {

    public ValidacionEmpresa(Empresa empresa) {
        super(empresa);
    }

    public boolean validarIdEmpresa(){
        System.out.println("Validating Empresa.IdEmpresa "+ entidad.getIdEmpresa());

        if (entidad.getIdEmpresa()<=-1)
            return false;

        return true;
    }
    public boolean validarCorreo(){
        System.out.println("Validating Empresa.Correo "+entidad.getCorreo());
        if (entidad.getCorreo() == null)
            return  false;

        if (entidad.getCorreo().isEmpty())
            return  false;

        return true;
    }

    public boolean validarNombre(){
        System.out.println("Validating Empresa.Nombre " +entidad.getNombre());
        if (entidad.getNombre() == null)
            return false;
        if (entidad.getNombre().isEmpty())
            return false;

        return true;
    }
    public boolean validarDireccion (){
        System.out.println("Validating Empresa.Direccion "+ entidad.getDireccion());
        if (entidad.getDireccion() == null)
            return  false;
        if (entidad.getDireccion().isEmpty())
            return false;
        return true;
    }

    public boolean validarNumTelefono(){
        System.out.println("Validating Empresa.NumTelefono "+ entidad.getNumTelefono());
        if (entidad.getNumTelefono() == null)
            return false;

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
