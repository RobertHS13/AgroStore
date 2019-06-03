package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioDetalleVenta;
import com.example.agrostore01.CapaEntidades.DetalleVenta;

import java.util.ArrayList;

public class LectorDetallesVenta extends Lector<DetalleVenta> {

    private RepositorioDetalleVenta repositorio = new RepositorioDetalleVenta();

    @Override
    public DetalleVenta getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<DetalleVenta> getEntidades() {
        return  repositorio.seleccionarTodo();
    }
}
