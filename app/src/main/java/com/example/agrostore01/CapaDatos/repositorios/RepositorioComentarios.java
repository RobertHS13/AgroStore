package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;

import java.util.ArrayList;

public class RepositorioComentarios extends Repositorio implements IContratoRelacion {

    public RepositorioComentarios() {
        this.sqlAlta="inser into Comentarios values (?, ?, ?, ?, ?)";
        this.sqlBaja="delete from Comentarios where IDComentarios = ?";
        this.sqlCambio="update Comentarios set " +
                "IDComentarios = ?," +
                "IDUsuario = ?," +
                "Comentario = ?, " +
                "Fecha = ?," +
                "Respuesta = ?" +
                "where IDComentarios= ?";
        this.sqlSeleccionarId="select * from Comentarios where IDComentarios = ?";
        this.sqlSeleccionarTodo="select * from Comentarios";
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
