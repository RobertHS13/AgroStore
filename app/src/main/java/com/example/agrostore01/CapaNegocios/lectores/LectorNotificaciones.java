package com.example.agrostore01.CapaNegocios.lectores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioNotificaciones;
import com.example.agrostore01.CapaEntidades.Notificaciones;

import java.util.ArrayList;

public class LectorNotificaciones extends Lector<Notificaciones> {

     private RepositorioNotificaciones repositorio = new RepositorioNotificaciones();
    @Override
    public Notificaciones getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<Notificaciones> getEntidades() {
         return repositorio.seleccionarTodo();

    }
}
