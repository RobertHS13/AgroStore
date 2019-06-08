package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Categorias;

import java.util.ArrayList;

public class ValidacionCategorias extends Validacion<Categorias> {

    public ValidacionCategorias(Categorias categorias) {
        super(categorias);
    }

    public boolean validarIdCategoria(){
        System.out.println("Validating Categorias.IdCategoria "+ entidad.getIdCategoria());

        if (entidad.getIdCategoria() <=- 1)
            return false;

        return true;
    }

    public boolean validarNombre(){
        System.out.println("Validating Categorias.Nombre  "+ entidad.getNombre());
        if(entidad.getNombre() == null)
            return false;

        if (entidad.getNombre().isEmpty())
            return false;

        return true;
    }
    @Override
    public boolean validar() {
        return validarIdCategoria() && validarNombre();
    }

}
