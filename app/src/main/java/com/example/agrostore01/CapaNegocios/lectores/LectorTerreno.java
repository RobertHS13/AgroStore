package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioTerreno;
import com.example.agrostore01.CapaEntidades.Terreno;

import java.util.ArrayList;

public class LectorTerreno extends Lector<Terreno> {
    private  RepositorioTerreno repositorio = new RepositorioTerreno();
    @Override
    public Terreno getEntidadId(Object id) {
        return    repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<Terreno> getEntidades() {
        return repositorio.seleccionarTodo();
    }
}
