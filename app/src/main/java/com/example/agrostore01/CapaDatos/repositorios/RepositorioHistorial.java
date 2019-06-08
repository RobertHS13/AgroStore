package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;
import com.example.agrostore01.CapaEntidades.Historial;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioHistorial extends Repositorio implements IContratoRelacion<Historial> {
    public RepositorioHistorial(){
        this.sqlAlta = "insert into Historial values (?,?)";
        this.sqlBaja = "delete from Historial where IDHistorial = ?";
        this.sqlCambio = "update Historial set" +
                "IDHistorial  = ?," +
                "Busqueda= ?," +
                "IDUsuario = ?" +
                "where IDHistorial = ?";
        this.sqlSeleccionarId = "select * from Historial where IDHistorial = ?";
        this.sqlSeleccionarTodo = "select * from Historial";
    }

    @Override
    public boolean alta(Historial e) {
        parametros = new ArrayList<>();
        // parametros.add(e.getIDHistorial());
        parametros.add(e.getBusqueda());
        parametros.add(e.getIdUsuario());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Historial e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdHistorial());
        parametros.add(e.getBusqueda());
        parametros.add(e.getIdUsuario());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public Historial seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();

            long idhistorial = resultado.getLong("IDHistorial");
            String busqueda = resultado.getString("Busqueda");
            String idusuario = resultado.getString("IDUsuario");
            return new Historial(idhistorial,busqueda,idusuario);
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
    public ArrayList<Historial> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Historial> historial = new ArrayList<>();

        try {
            while (resultado.next()) {
                long idhistorial = resultado.getLong("IDHistorial");
                String busqueda = resultado.getString("Busqueda");
                String idusuario = resultado.getString("IDUsuario");
                historial.add(new Historial(idhistorial,busqueda,idusuario));
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
        return historial;
    }

    @Override
    public boolean bajaEspecifica(Historial e) {
        return false;
    }

    @Override
    public ArrayList<Historial> seleccionarTodosId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);
        ArrayList<Historial> historial = new ArrayList<>();

        try {
            while (resultado.next()) {
                long idhistorial = resultado.getLong("IDHistorial");
                String busqueda = resultado.getString("Busqueda");
                String idusuario = resultado.getString("IDUsuario");
                historial.add(new Historial(idhistorial,busqueda,idusuario));
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
        return historial;
    }

}
