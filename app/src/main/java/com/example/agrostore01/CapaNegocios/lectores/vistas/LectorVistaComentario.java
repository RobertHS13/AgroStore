package com.example.agrostore01.CapaNegocios.lectores.vistas;

import com.example.agrostore01.CapaDatos.repositorios.vistas.RepositorioVistaComentarios;
import com.example.agrostore01.CapaEntidades.vistas.VistaComentarios;
import com.example.agrostore01.CapaNegocios.lectores.Lector;

import java.util.ArrayList;
import java.util.List;

public class LectorVistaComentario extends Lector<VistaComentarios> {

    private RepositorioVistaComentarios repositorio = new RepositorioVistaComentarios();

    @Override
    public VistaComentarios getEntidadId(Object id) {
        return null;
    }

    @Override
    public ArrayList<VistaComentarios> getEntidades() {
        return null;
    }

    public List<VistaComentarios> getComentarios(int idProductoTerreno) {
        return repositorio.seleccionarComentarios(idProductoTerreno);
    }

}
