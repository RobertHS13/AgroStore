package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioTipoUsuario;
import com.example.agrostore01.CapaEntidades.TipoUsuario;

import java.util.ArrayList;

public class LectorTipoUsuario extends Lector<TipoUsuario> {
    private RepositorioTipoUsuario repositorio = new RepositorioTipoUsuario();

    @Override
    public TipoUsuario getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<TipoUsuario> getEntidades() {
        return repositorio.seleccionarTodo();
    }
}