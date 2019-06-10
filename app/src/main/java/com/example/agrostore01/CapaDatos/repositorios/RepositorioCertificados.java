package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.Certificados;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;

public class RepositorioCertificados extends Repositorio implements IContrato<Certificados> {

    public RepositorioCertificados() {
        this.sqlAlta="inser into Certificado values (?,?,?,?,?)";
        this.sqlBaja="delete from Certificado where IDCertificado = ?";
        this.sqlCambio="update Certificado set " +
                "IDCertificado = ?," +
                "Nombre = ?," +
                "Vigencia = ?, " +
                "TituloCertificado = ?," +
                "FechaExpedido = ?," +
                "Sello = ?" +
                "where IDCertificados= ?";
        this.sqlSeleccionarId="select * from Certificado where IDCertificado = ?";
        this.sqlSeleccionarTodo="select * from Certificado";
    }


    @Override
    public boolean alta(Certificados e) {
    parametros = new ArrayList<>();
    //parametros.add(e.getIdCertificados());
    parametros.add(e.getNombre());
    parametros.add(e.getVigencia());
    parametros.add(e.getTituloCertificado());
    parametros.add(e.getFechaExpedido());
    parametros.add(e.getSello());
    return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
    parametros.add(id);
    return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Certificados e) {
    parametros = new ArrayList<>();
    parametros.add(e.getIdCertificados());
    parametros.add(e.getNombre());
    parametros.add(e.getVigencia());
    parametros.add(e.getTituloCertificado());
    parametros.add(e.getFechaExpedido());
    parametros.add(e.getSello());
    parametros.add(id);
    return ejecutarConsulta(sqlCambio);
    }

    @Override
    public Certificados seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            int IDCertificado = resultado.getInt("IDCertificado");
            String Nombre = resultado.getString("Nombre");
            Timestamp Vigencia = resultado.getTimestamp("Vigencia");
            String TituloCertificado = resultado.getString("TituloCertificado");
            Timestamp FechaExpedido= resultado.getTimestamp("FechaExpedido");
            byte[] Sello =resultado.getBytes("Sello");
            return new Certificados(IDCertificado,Nombre,Vigencia,TituloCertificado,FechaExpedido,Sello);
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
    public ArrayList<Certificados> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Certificados> certificados = new ArrayList<>();

        try {
            while (resultado.next()) {
                int IDCertificado = resultado.getInt("IDCertificado");
                String Nombre = resultado.getString("Nombre");
                Timestamp Vigencia = resultado.getTimestamp("Vigencia");
                String TituloCertificado = resultado.getString("TituloCertificado");
                Timestamp FechaExpedido= resultado.getTimestamp("FechaExpedido");
                byte[] Sello =resultado.getBytes("Sello");
                certificados.add(new Certificados(IDCertificado,Nombre,Vigencia,TituloCertificado,FechaExpedido,Sello));
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
        return certificados;
    }
}
