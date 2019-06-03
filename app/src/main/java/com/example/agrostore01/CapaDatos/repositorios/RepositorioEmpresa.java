package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.Empresa;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioEmpresa extends Repositorio implements IContrato<Empresa> {

    public RepositorioEmpresa(){
        this.sqlAlta = "insert into Empresa values (?, ?, ?, ?)";
        this.sqlBaja = "delete from Empresa where IDEmpresa = ?";
        this.sqlCambio = "update Empresa set " +
                "IDEmpresa = ?," +
                "Nombre = ?, " +
                "Dirección = ?, " +
                "NumTelefono = ?, " +
                "Correo = ?, " +
                "where IDEmpresa = ?";
        this.sqlSeleccionarId = "select * from Empresa where IDEmpresa = ?";
        this.sqlSeleccionarTodo = "select * from Empresa";

    }

    @Override
    public boolean alta(Empresa e) {

        parametros = new ArrayList<>();
        parametros.add(e.getNombre());
        parametros.add(e.getDireccion());
        parametros.add(e.getNumTelefono());
        parametros.add(e.getCorreo());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Empresa e) {

        parametros = new ArrayList<>();
        parametros.add(e.getIdEmpresa());
        parametros.add(e.getNombre());
        parametros.add(e.getDireccion());
        parametros.add(e.getNumTelefono());
        parametros.add(e.getCorreo());
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public Empresa seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            int IDEmpresa = resultado.getInt("IDEmpresa");
            String Nombre = resultado.getString("Nombre");
            String Direccion = resultado.getString("Dirección");
            String NumTelefono = resultado.getString("NumTelefono");
            String Correo = resultado.getString("Correo");


            return new Empresa(IDEmpresa,Nombre,Direccion,NumTelefono,Correo);
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
    public ArrayList<Empresa> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Empresa> empresas = new ArrayList<>();

        try {
            while (resultado.next()) {
                int IDEmpresa = resultado.getInt("IDEmpresa");
                String Nombre = resultado.getString("Nombre");
                String Direccion = resultado.getString("Dirección");
                String NumTelefono = resultado.getString("NumTelefono");
                String Correo = resultado.getString("Correo");

                empresas.add(new Empresa(IDEmpresa,Nombre,Direccion,NumTelefono,Correo));
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
        return empresas;

    }
}
