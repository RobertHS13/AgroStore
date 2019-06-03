package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioCategorias;
import com.example.agrostore01.CapaEntidades.Categorias;

import java.util.ArrayList;

public class LectorCategorias extends Lector<Categorias> {
    private RepositorioCategorias repositorio = new RepositorioCategorias();
    @Override
    public Categorias getEntidadId(Object id) {
        return repositorio.seleccionarId(id);

    }

    @Override
    public ArrayList<Categorias> getEntidades() {
        return repositorio.seleccionarTodo();
    }
}
