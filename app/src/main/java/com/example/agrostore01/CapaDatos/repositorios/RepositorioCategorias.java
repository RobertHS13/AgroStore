package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.Categorias;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioCategorias extends Repositorio implements IContrato<Categorias> {

    public RepositorioCategorias(){
        this.sqlAlta="insert into Categorias values (?)";
        this.sqlBaja="delete from Categorias where IDCategorias = ?";
        this.sqlCambio="update Categorias set " +
                "IDCategorias = ?,"+
                "Nombre = ?" +
                "where IDCategorias = ?";
        this.sqlSeleccionarId="select * from Categorias where IDCategorias = ?";
        this.sqlSeleccionarTodo="select * from Categorias";

    }

    @Override
    public boolean alta(Categorias e) {
        parametros = new ArrayList<>();
        //parametros.add(e.getIdCategoria());
        parametros.add(e.getNombre());
        return ejecutarConsulta(sqlAlta);

    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);

    }

    @Override
    public boolean cambio(Object id, Categorias e) {
        parametros= new ArrayList<>();
        parametros.add(e.getIdCategoria());
        parametros.add(e.getNombre());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);

    }

    @Override
    public Categorias seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();

            int IDCategoria = resultado.getInt("IDCategoria");
            String Nombre = resultado.getString("Nombre");

            return new Categorias(IDCategoria,Nombre);
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
    public ArrayList<Categorias> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Categorias> categorias = new ArrayList<>();

        try {
            while (resultado.next()) {
                int IDCategoria = resultado.getInt("IDCategoria");
                String Nombre = resultado.getString("Nombre");
                categorias.add(new Categorias(IDCategoria,Nombre));
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
        return categorias;
    }
}
