package com.example.agrostore01.CapaNegocios.lectores.vistas;

import com.example.agrostore01.CapaDatos.repositorios.vistas.RepositorioMisVentas;
import com.example.agrostore01.CapaEntidades.vistas.VistaMisVentas;
import com.example.agrostore01.CapaNegocios.lectores.Lector;

import java.util.ArrayList;
import java.util.List;

public class LectorMisVentas extends Lector<VistaMisVentas> {

    private RepositorioMisVentas repositorio = new RepositorioMisVentas();

    @Override
    public VistaMisVentas getEntidadId(Object id) {
        return null;
    }

    @Override
    public ArrayList<VistaMisVentas> getEntidades() {
        return null;
    }

    public List<VistaMisVentas> getMisVentas(String idUsuario) {
        return repositorio.seleccionarMisVentas(idUsuario);
    }

}
