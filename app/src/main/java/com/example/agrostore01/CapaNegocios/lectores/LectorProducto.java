package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioProducto;
import com.example.agrostore01.CapaEntidades.Producto;

import java.util.ArrayList;
import java.util.List;

public class LectorProducto extends Lector<Producto> {

    private RepositorioProducto repositorio = new RepositorioProducto();

    @Override
    public Producto getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<Producto> getEntidades() {
        return repositorio.seleccionarTodo();
    }

    public List<Integer> getIdProductosConCategoria(String categoria) {
        return repositorio.seleccionarIdProductosConCategoria(categoria);
    }

    public List<Integer> getIdProductosConNombre(String nombre) {
        return repositorio.seleccionarIdProductosConNombre(nombre);
    }

    public List<Integer> getIdProductosConFiltros(long precioMin, long precioMax, String producto,
                                                  String categoria, String temporada, String pais,
                                                  String estado, float estrellas) {

        return repositorio.seleccionarIdProductosConFiltros(
                precioMin, precioMax, producto, categoria, temporada, pais, estado, estrellas
        );
    }
}
