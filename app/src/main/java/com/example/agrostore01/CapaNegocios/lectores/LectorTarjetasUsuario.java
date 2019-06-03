package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioTarjetasUsuario;
import com.example.agrostore01.CapaEntidades.TarjetasUsuario;

import java.util.ArrayList;

public class LectorTarjetasUsuario extends LectorRelacion<TarjetasUsuario> {
    private  RepositorioTarjetasUsuario repositorio = new RepositorioTarjetasUsuario();
    @Override
    public ArrayList<TarjetasUsuario> getEntidadesId(Object id) {
        return null;
    }

    @Override
    public TarjetasUsuario getEntidadId(Object id) {
        return repositorio.seleccionarId(id);

    }

    @Override
    public ArrayList<TarjetasUsuario> getEntidades() {
        return repositorio.seleccionarTodo();

    }

}
