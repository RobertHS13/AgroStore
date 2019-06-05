package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioTarjetas;
import com.example.agrostore01.CapaEntidades.Tarjetas;

import java.util.ArrayList;

public  class LectorTarjetas extends Lector<Tarjetas> {
    private RepositorioTarjetas repositorio = new RepositorioTarjetas();
    @Override
    public Tarjetas getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<Tarjetas> getEntidades() {
        return repositorio.seleccionarTodo();

    }




}
