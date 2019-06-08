package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;
import com.example.agrostore01.CapaEntidades.UsuarioNotificaciones;

import java.util.ArrayList;

public class RepositorioUsuarioNotificaciones extends Repositorio implements IContratoRelacion<UsuarioNotificaciones> {

    public RepositorioUsuarioNotificaciones(){
        this.sqlAlta = "insert into UsuarioNotificaciones values (?)";
        this.sqlBaja = "delete from UsuarioNotificaciones where IDUsuario = ?";
        this.sqlCambio = "update UsuarioNotificaciones set" +
                "IDUsuario = ?, " +
                "IDNotificacion = ?, " +
                "where IDUsuario = ?";
        this.sqlSeleccionarId = "select * from UsuarioNotificaciones where IDUsuario = ?";
        this.sqlSeleccionarTodo = "select * from UsuarioNotificaciones";
    }
    @Override
    public boolean alta(UsuarioNotificaciones e) {
       parametros = new ArrayList<>();
       //parametros.add(e.getIdUsuario());
       parametros.add(e.getIdNotificacion());
       return ejecutarConsulta(sqlAlta);

    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, UsuarioNotificaciones e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdUsuario());
        parametros.add(e.getIdNotificacion());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public UsuarioNotificaciones seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            String idUsuario = resultado.getString("IDUsuario");
            long idNotificaciones =resultado.getLong("IDNotificaciones");
            return new UsuarioNotificaciones(idUsuario,idNotificaciones);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    @Override
    public ArrayList<UsuarioNotificaciones> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<UsuarioNotificaciones> usuarioNotificaciones = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idUsuario = resultado.getString("IDUsuario");
                long idNotificaciones =resultado.getLong("IDNotificaciones");
                usuarioNotificaciones.add(new UsuarioNotificaciones(idUsuario,idNotificaciones));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return usuarioNotificaciones;
    }

    @Override
    public boolean bajaEspecifica(UsuarioNotificaciones e) {
        return false;
    }

    @Override
    public ArrayList<UsuarioNotificaciones> seleccionarTodosId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);
        ArrayList<UsuarioNotificaciones> usuarioNotificaciones = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idUsuario = resultado.getString("IDUsuario");
                long idNotificaciones =resultado.getLong("IDNotificaciones");
                usuarioNotificaciones.add(new UsuarioNotificaciones(idUsuario,idNotificaciones));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return usuarioNotificaciones;
    }
}
