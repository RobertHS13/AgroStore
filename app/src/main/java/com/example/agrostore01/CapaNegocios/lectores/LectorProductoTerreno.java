package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioProductoTerreno;
import com.example.agrostore01.CapaEntidades.ProductoTerreno;

import java.util.ArrayList;

public class LectorProductoTerreno extends  LectorRelacion<ProductoTerreno> {
    private RepositorioProductoTerreno repositorio = new RepositorioProductoTerreno();
    @Override
    public ArrayList<ProductoTerreno> getEntidadesId(Object id) {
        return  null;
    }

    @Override
    public ProductoTerreno getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<ProductoTerreno> getEntidades()
    {
        return repositorio.seleccionarTodo();
    }
}
