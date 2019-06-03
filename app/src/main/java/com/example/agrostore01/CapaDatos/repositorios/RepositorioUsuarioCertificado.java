package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.UsuarioCertificado;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioUsuarioCertificado extends Repositorio implements IContrato<UsuarioCertificado> {
    public RepositorioUsuarioCertificado(){
        this.sqlAlta = "insert into UsuarioCertificado values (?, ?)";
        this.sqlBaja = "delete from UsuarioCertificado where IDUsuario = ?";
        this.sqlCambio = "update UsuarioCertificado set " +
                "IDUsuario = ?," +
                "IDCertificados = ? " +
                "where IDUsuario = ?";
        this.sqlSeleccionarId = "select * from UsuarioCertificado where IDUsuario = ?";
        this.sqlSeleccionarTodo = "select * from UsuarioCertificado";


    }
    @Override
    public boolean alta(UsuarioCertificado e) {
        parametros = new ArrayList<>();
        //parametros.add(e.getIdUsuario());
        parametros.add(e.getIdCertificados());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, UsuarioCertificado e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdUsuario());
        parametros.add(e.getIdCertificados());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public UsuarioCertificado seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            String idUsuario = resultado.getString("IDUsuario");
            int idCertificado = resultado.getInt("IDCertificado");
            return new UsuarioCertificado(idUsuario,idCertificado);
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
    public ArrayList<UsuarioCertificado> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<UsuarioCertificado> usuarioCertificados = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idUsuario = resultado.getString("IDUsuario");
                int idCertificado = resultado.getInt("IDCertificado");
                usuarioCertificados.add(new UsuarioCertificado(idUsuario,idCertificado));
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
        return usuarioCertificados;
    }
}
