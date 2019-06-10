package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioCompraUsuario;
import com.example.agrostore01.CapaEntidades.CompraUsuario;

import java.util.ArrayList;

public class LectorCompraUsuario extends LectorRelacion<CompraUsuario> {
    private RepositorioCompraUsuario repositorio = new RepositorioCompraUsuario();
    @Override
    public ArrayList<CompraUsuario> getEntidadesId(Object id) {
        return repositorio.seleccionarTodosId(id);
    }

    @Override
    public CompraUsuario getEntidadId(Object id) {
         return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<CompraUsuario> getEntidades() {
        return repositorio.seleccionarTodo();

    }
}
