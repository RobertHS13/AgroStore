package com.example.agrostore01.CapaNegocios.lectores.vistas;

import com.example.agrostore01.CapaDatos.repositorios.vistas.RepositorioVistaTerreno;
import com.example.agrostore01.CapaEntidades.vistas.VistaTerreno;
import com.example.agrostore01.CapaNegocios.lectores.Lector;

import java.util.ArrayList;
import java.util.List;

public class LectorVistaTerreno extends Lector<VistaTerreno> {

    private RepositorioVistaTerreno repositorio = new RepositorioVistaTerreno();

    @Override
    public VistaTerreno getEntidadId(Object id) {
        return null;
    }

    @Override
    public ArrayList<VistaTerreno> getEntidades() {
        return null;
    }

    public List<VistaTerreno> getTerrenos(String idUsuario) {
        return repositorio.seleccionarTerrenos(idUsuario);
    }

}
