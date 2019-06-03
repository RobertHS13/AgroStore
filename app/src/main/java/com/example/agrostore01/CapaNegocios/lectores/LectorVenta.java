package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioVenta;
import com.example.agrostore01.CapaEntidades.Venta;

import java.util.ArrayList;

public class LectorVenta extends Lector<Venta> {
    private  RepositorioVenta repositorio = new RepositorioVenta();
    @Override
    public Venta getEntidadId(Object id) {
        return repositorio.seleccionarId(id);

    }

    @Override
    public ArrayList<Venta> getEntidades() {
        return repositorio.seleccionarTodo();

    }
}
