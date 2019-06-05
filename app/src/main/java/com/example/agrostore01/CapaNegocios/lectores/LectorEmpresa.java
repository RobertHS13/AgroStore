package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioEmpresa;
import com.example.agrostore01.CapaEntidades.Empresa;

import java.util.ArrayList;

public class LectorEmpresa extends Lector<Empresa> {
    private RepositorioEmpresa repositorio = new RepositorioEmpresa();
    @Override
    public Empresa getEntidadId(Object id) {
        return repositorio.seleccionarId(id);

    }

    @Override
    public ArrayList<Empresa> getEntidades() {
        return repositorio.seleccionarTodo();
    }
}
