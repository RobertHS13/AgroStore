package com.example.agrostore01.CapaNegocios.lectores.vistas;

import com.example.agrostore01.CapaDatos.repositorios.vistas.RepositorioMisCompras;
import com.example.agrostore01.CapaEntidades.vistas.VistaMisCompras;
import com.example.agrostore01.CapaNegocios.lectores.Lector;

import java.util.ArrayList;
import java.util.List;

public class LectorMisCompras extends Lector<VistaMisCompras> {

    private RepositorioMisCompras repositorio = new RepositorioMisCompras();

    @Override
    public VistaMisCompras getEntidadId(Object id) {
        return null;
    }

    @Override
    public ArrayList<VistaMisCompras> getEntidades() {
        return null;
    }

    public List<VistaMisCompras> getMisCompras(String idUsuario) {
        return repositorio.seleccionarMisCompras(idUsuario);
    }

}
