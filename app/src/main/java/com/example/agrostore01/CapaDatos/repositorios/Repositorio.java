package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.conexiones.BaseDeDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repositorio {
    protected BaseDeDatos bd = new BaseDeDatos("hola","hola","hola","hola");
    //falta mandarle bien los parametros

    protected PreparedStatement sentencia;
    protected ResultSet resultado;
    protected ArrayList<Object> parametros = new ArrayList<>();

    protected String sqlAlta;
    protected String sqlBaja;
    protected String sqlCambio;
    protected String sqlSeleccionarId;
    protected String sqlSeleccionarTodo;

    public Repositorio() {}

    protected boolean ejecutarConsulta(String sql) {
        try {
            sentencia = bd.getConexion().prepareStatement(sql);

            int i = 1;
            for (Object p : parametros)
                sentencia.setObject(i++, p);

            System.out.println("Consulta: " + sql);
            System.out.println("Datos: " + parametros);

            sentencia.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            parametros.clear();
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return true;
    }

    protected ResultSet ejecutarLectura(String sql) {
        try {
            sentencia = bd.getConexion().prepareStatement(sql);

            int i = 1;
            for (Object p : parametros)
                sentencia.setObject(i++, p);

            System.out.println("Lectura: " + sql);
            System.out.println("Datos: " + parametros);

            resultado = sentencia.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            parametros.clear();
        }
        return resultado;
    }

}
