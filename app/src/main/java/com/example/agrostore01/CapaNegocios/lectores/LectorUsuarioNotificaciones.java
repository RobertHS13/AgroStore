package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioUsuarioNotificaciones;
import com.example.agrostore01.CapaEntidades.UsuarioNotificaciones;

import java.util.ArrayList;

public class LectorUsuarioNotificaciones extends LectorRelacion<UsuarioNotificaciones> {
    private RepositorioUsuarioNotificaciones repositorio = new RepositorioUsuarioNotificaciones();

    @Override
    public ArrayList<UsuarioNotificaciones> getEntidadesId(Object id) {
        return null;
    }

    @Override
    public UsuarioNotificaciones getEntidadId(Object id) {
        return  repositorio.seleccionarId(id);


    }

    @Override
    public ArrayList<UsuarioNotificaciones> getEntidades() {
        return repositorio.seleccionarTodo();

    }
}
