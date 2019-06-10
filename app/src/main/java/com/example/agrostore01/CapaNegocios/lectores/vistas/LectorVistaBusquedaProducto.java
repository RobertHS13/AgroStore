package com.example.agrostore01.CapaNegocios.lectores.vistas;

import com.example.agrostore01.CapaDatos.repositorios.vistas.RepositorioVistaBusquedaProducto;
import com.example.agrostore01.CapaEntidades.vistas.VistaBusquedaProducto;
import com.example.agrostore01.CapaNegocios.lectores.Lector;

import java.util.ArrayList;

public class LectorVistaBusquedaProducto extends Lector<VistaBusquedaProducto> {

    private RepositorioVistaBusquedaProducto repositorio = new RepositorioVistaBusquedaProducto();

    @Override
    public VistaBusquedaProducto getEntidadId(Object id) {
        return repositorio.seleccionarEntidadIdProducto(id);
    }

    @Override
    public ArrayList<VistaBusquedaProducto> getEntidades() {
        return null;
    }

}
