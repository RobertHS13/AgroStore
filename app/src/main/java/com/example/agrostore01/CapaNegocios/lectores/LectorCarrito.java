package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioCarrito;
import com.example.agrostore01.CapaEntidades.Carrito;

import java.util.ArrayList;

public class LectorCarrito extends Lector<Carrito> {

    private RepositorioCarrito repositorio = new RepositorioCarrito();

    @Override
    public Carrito getEntidadId(Object id) {
        return repositorio.seleccionarId(id);

    }

    @Override
    public ArrayList<Carrito> getEntidades() {
        return repositorio.seleccionarTodo();
    }

}
