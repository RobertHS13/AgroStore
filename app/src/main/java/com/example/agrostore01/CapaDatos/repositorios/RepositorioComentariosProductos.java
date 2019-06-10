package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;

import java.util.ArrayList;

public class RepositorioComentariosProductos extends Repositorio implements IContratoRelacion {

    public RepositorioComentariosProductos() {
        this.sqlAlta="insert into ComentariosProductos values (?, ?)";
        this.sqlBaja="delete from ComentariosProductos where IDComentarios = ?";
        this.sqlCambio="update ComentariosProductos set " +
                "IDComentarios = ?," +
                "IDProductoTerreno = ?," +
                "where IDComentarios = ?";
        this.sqlSeleccionarId="select * from ComentariosProductos where IDComentarios = ?";
        this.sqlSeleccionarTodo="select * from ComentariosProductos";
    }

    @Override
    public boolean alta(Object e) {
        return false;
    }

    @Override
    public boolean baja(Object id) {
        return false;
    }

    @Override
    public boolean cambio(Object id, Object e) {
        return false;
    }

    @Override
    public Object seleccionarId(Object id) {
        return null;
    }

    @Override
    public ArrayList seleccionarTodo() {
        return null;
    }

    @Override
    public boolean bajaEspecifica(Object e) {
        return false;
    }

    @Override
    public ArrayList seleccionarTodosId(Object id) {
        return null;
    }

}
