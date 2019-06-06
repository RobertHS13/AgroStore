package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;

import java.util.ArrayList;

public class LectorUsuario extends Lector<Usuario> {

    private RepositorioUsuario repositorio = new RepositorioUsuario();

    @Override
    public Usuario getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<Usuario> getEntidades() {
        return repositorio.seleccionarTodo();
    }

    public Usuario getEntidadNombreUsuario(String nombreUsuario) { return repositorio.seleccionarNombreUsuario(nombreUsuario); }

    public boolean confirmarExistencia(String idUsuario, String contrasena) {
        return repositorio.confirmarExistencia(idUsuario, contrasena);
    }

    public String getContrasena(String idUsuario) {
        return repositorio.seleccionarContrasena(idUsuario);
    }

}
