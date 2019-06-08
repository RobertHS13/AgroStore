package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.TipoUsuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioTipoUsuario extends Repositorio implements IContrato<TipoUsuario> {

    public RepositorioTipoUsuario(){
        this.sqlAlta = "insert into TipoUsuario values (?)";
        this.sqlBaja = "delete from TipoUsuario where IDTipo = ?";
        this.sqlCambio = "update TipoUsuario set " +
                "IDTipo = ?," +
                "TipoUsuario = ? " +
                "where IDTipo = ?";
        this.sqlSeleccionarId = "select * from TipoUsuario where IDTipo = ?";
        this.sqlSeleccionarTodo = "select * from TipoUsuario";


    }
    @Override
    public boolean alta(TipoUsuario e) {
        parametros= new ArrayList<>();
        //parametros.add(e.getIdTipo());
        parametros.add(e.getTipoUsuario());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, TipoUsuario e) {
        parametros= new ArrayList<>();
        parametros.add(e.getIdTipo());
        parametros.add(e.getTipoUsuario());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public TipoUsuario seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            int idTipo = resultado.getInt("IDTipo");
            String tipoUsuario = resultado.getString("TipoUsuario");
            return new TipoUsuario(idTipo,tipoUsuario);
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
    public ArrayList<TipoUsuario> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<TipoUsuario> tipoUsuarios = new ArrayList<>();

        try {
            while (resultado.next()) {
                int idTipo = resultado.getInt("IDTipo");
                String tipoUsuario = resultado.getString("TipoUsuario");
                tipoUsuarios.add(new TipoUsuario(idTipo,tipoUsuario));
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
        return tipoUsuarios;
    }
}
