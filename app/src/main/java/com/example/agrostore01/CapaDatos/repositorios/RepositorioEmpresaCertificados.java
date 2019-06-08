package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;
import com.example.agrostore01.CapaEntidades.EmpresaCertificados;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioEmpresaCertificados extends Repositorio implements IContratoRelacion<EmpresaCertificados> {

    public RepositorioEmpresaCertificados(){
        this.sqlAlta = "insert into EmpresaCertificado values (?, ?)";
        this.sqlBaja = "delete from EmpresaCertificado where IDCertificados = ?";
        this.sqlCambio = "update EmpresaCertificado set " +
                "IDCertificados = ?," +
                "IDEmpresa = ? " +
                "where IDCertificados = ?";
        this.sqlSeleccionarId = "select * from EmpresaCertificado where IDCertificados = ?";
        this.sqlSeleccionarTodo = "select * from EmpresaCertificado";


    }
    @Override
    public boolean alta(EmpresaCertificados e) {
        parametros = new ArrayList<>();
        //parametros.add(e.getIdEmpresa());
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
    public boolean cambio(Object id, EmpresaCertificados e) {

        parametros = new ArrayList<>();
        parametros.add(e.getIdEmpresa());
        parametros.add(e.getIdCertificados());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public EmpresaCertificados seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            int IDEmpresa = resultado.getInt("IDEmpresa");
            int IDCertificados= resultado.getInt("IDCertificado");

            return new EmpresaCertificados(IDEmpresa,IDCertificados);
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
    public ArrayList<EmpresaCertificados> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<EmpresaCertificados> empresaCertificados = new ArrayList<>();

        try {
            while (resultado.next()) {
                int IDEmpresa = resultado.getInt("IDEmpresa");
                int IDCertificados= resultado.getInt("IDCertificado");

                empresaCertificados.add(new EmpresaCertificados(IDEmpresa,IDCertificados));
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
        return empresaCertificados;
    }

    @Override
    public boolean bajaEspecifica(EmpresaCertificados e) {
        return false;
    }

    @Override
    public ArrayList<EmpresaCertificados> seleccionarTodosId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);
        ArrayList<EmpresaCertificados> empresaCertificados = new ArrayList<>();

        try {
            while (resultado.next()) {
                int IDEmpresa = resultado.getInt("IDEmpresa");
                int IDCertificados= resultado.getInt("IDCertificado");

                empresaCertificados.add(new EmpresaCertificados(IDEmpresa,IDCertificados));
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
        return empresaCertificados;
    }

}

