package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;
import com.example.agrostore01.CapaEntidades.TerrenosUsuario;

import java.util.ArrayList;

public class RepositorioTerrenosUsuario extends RepositorioRelacion implements IContratoRelacion<TerrenosUsuario> {

    public RepositorioTerrenosUsuario(){
        this.sqlAlta = "insert into TerrenoUsuario values (?, ?)";
        this.sqlBaja = "delete from TerrenoUsuario where IDUsuario = ?";
        this.sqlCambio = "update TerrenoUsuario set " +
                "IDUsuario = ?," +
                "IDTerreno = ? " +
                "where IDUsuario = ?";
        this.sqlSeleccionarId = "select * from TerrenoUsuario where IDUsuario = ?";
        this.sqlSeleccionarTodo = "select * from TerrenoUsuario";

    }
    @Override
    public boolean alta(TerrenosUsuario e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdUsuario());
        parametros.add(e.getIdTerreno());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    } //

    @Override
    public boolean cambio(Object id, TerrenosUsuario e) {
        parametros= new ArrayList<>();
        parametros.add(e.getIdUsuario());
        parametros.add(e.getIdTerreno());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public TerrenosUsuario seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            String idUsuario = resultado.getString("IDUsuario");
            long idTerreno = resultado.getInt("IDTerreno");
            return new TerrenosUsuario(idUsuario,idTerreno);
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
    public ArrayList<TerrenosUsuario> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<TerrenosUsuario> terrenosUsuarios = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idUsuario = resultado.getString("IDUsuario");
                long idTerreno = resultado.getInt("IDTerreno");
                terrenosUsuarios.add(new TerrenosUsuario(idUsuario,idTerreno));
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
        return terrenosUsuarios;
    }

    @Override
    public boolean bajaEspecifica(TerrenosUsuario e) {
        return false;
    }

    @Override
    public ArrayList<TerrenosUsuario> seleccionarTodosId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        resultado = ejecutarLectura(sqlSeleccionarId);
        ArrayList<TerrenosUsuario> terrenosUsuarios = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idUsuario = resultado.getString("IDUsuario");
                long idTerreno = resultado.getInt("IDTerreno");
                terrenosUsuarios.add(new TerrenosUsuario(idUsuario,idTerreno));
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
        return terrenosUsuarios;
    }
}
