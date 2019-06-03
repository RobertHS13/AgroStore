package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioUsuarioCertificado;
import com.example.agrostore01.CapaEntidades.UsuarioCertificado;

import java.util.ArrayList;

public class LectorUsuarioCertificado extends LectorRelacion<UsuarioCertificado> {
    private RepositorioUsuarioCertificado repositorio= new RepositorioUsuarioCertificado();

    @Override
    public UsuarioCertificado getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<UsuarioCertificado> getEntidades() {
        return repositorio.seleccionarTodo();
    }

    @Override
    public ArrayList<UsuarioCertificado> getEntidadesId(Object id) {
        return null;
    }
}
