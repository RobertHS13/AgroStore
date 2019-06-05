package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.Notificaciones;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioNotificaciones extends Repositorio implements IContrato<Notificaciones> {

    public RepositorioNotificaciones(){
        this.sqlAlta = "insert into Notificaciones values (?)";
        this.sqlBaja = "delete from Notificaciones where IDNotificaciones = ?";
        this.sqlCambio = "update Notificaciones set" +
                "IDNotificaciones = ?, " +
                "Detalle = ? " +
                "where IDNotificaciones = ?";
        this.sqlSeleccionarId = "select * from Notificaciones where IDNotificaciones = ?";
        this.sqlSeleccionarTodo = "select * from Notificaciones";

    }
    @Override
    public boolean alta(Notificaciones e) {
    parametros = new ArrayList<>();
    //parametros.add(e.getIdNotificacion());
    parametros.add(e.getDetalle());
    return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Notificaciones e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdNotificacion());
        parametros.add(e.getDetalle());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public Notificaciones seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            long IDNotificaciones = resultado.getLong("IDNotificaciones");
            String Detalle = resultado.getString("Detalle");
            return new Notificaciones(IDNotificaciones,Detalle);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    @Override
    public ArrayList<Notificaciones> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Notificaciones> notificaciones = new ArrayList<>();

        try {
            while (resultado.next()) {
                long IDNotificaciones = resultado.getLong("IDNotificaciones");
                String Detalle = resultado.getString("Detalle");
                notificaciones.add(new Notificaciones(IDNotificaciones,Detalle));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return notificaciones;
    }
    }

