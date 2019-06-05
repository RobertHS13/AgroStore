package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Categorias;

import java.util.ArrayList;

public class ValidacionCategorias extends Validacion<Categorias> {


    public ValidacionCategorias(Categorias categorias) {
        super(categorias);
    }

    public boolean validarIdCategoria(){
        if (entidad.getIdCategoria()==0)
            return false;
        return true;
    }
    public boolean validarNombre(){
        if (entidad.getNombre().isEmpty())
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdCategoria() && validarNombre();
    }

}
