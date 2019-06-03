package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioHistorial;
import com.example.agrostore01.CapaEntidades.Historial;

import java.util.ArrayList;

public class LectorHistorial extends Lector<Historial> {

    private RepositorioHistorial repositorio = new RepositorioHistorial();
    @Override
    public Historial getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<Historial> getEntidades() {
        return repositorio.seleccionarTodo();
    }
}
