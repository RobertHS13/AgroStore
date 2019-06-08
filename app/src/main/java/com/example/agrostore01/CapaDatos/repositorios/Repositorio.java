package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.conexiones.BaseDeDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    protected BaseDeDatos bd = new BaseDeDatos();

    protected PreparedStatement sentencia;
    protected ResultSet resultado;
    protected ArrayList<Object> parametros = new ArrayList<>();

    protected CallableStatement procedimiento;
    protected ArrayList<Integer> parametrosDeSalida = new ArrayList<>();

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

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            parametros.clear();
            try { if (resultado != null) resultado.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    protected ResultSet ejecutarLectura(String sql) {
        try {
            sentencia = bd.getConexion().prepareStatement(sql);

            int i = 1;
            for (Object p : parametros)
                sentencia.setObject(i++, p);

            System.out.println("Lectura: " + sql);
            System.out.println("Datos: " + parametros);

            return sentencia.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            parametros.clear();
        }
    }

    protected boolean ejecutarProcedimiento(String sql) {
        try {
            procedimiento = bd.getConexion().prepareCall(sql);

            int i = 1;
            for (Object p : parametros)
                procedimiento.setObject(i++, p);

            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("Procedimiento: " + sql);
            System.out.println("Parametros de entrada: " + parametros);
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");
            System.out.println("~~~~~~~~");

            procedimiento.executeUpdate();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            parametros.clear();
        }
    }

    protected ResultSet ejecutarProcedimientoConSalida(String sql) {
        try {

            procedimiento = bd.getConexion().prepareCall(sql);

            int i = 1;
            for (Object p : parametros)
                procedimiento.setObject(i++, p);

            for (Integer type : parametrosDeSalida) {
                System.out.println("Setting sql type " + type + " on index " + i);
                procedimiento.registerOutParameter(i++, type);
            }

            System.out.println("Procedimiento: " + sql);
            System.out.println("Parametros de entrada: " + parametros);
            System.out.println("Parametros de salida: " + parametrosDeSalida);

            boolean generatedResultSet = procedimiento.execute();
            if (generatedResultSet) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("The proc generated a result set!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                return procedimiento.getResultSet();
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("The proc did NOT generate a result set!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            parametros.clear();
            parametrosDeSalida.clear();
        }
    }

}
