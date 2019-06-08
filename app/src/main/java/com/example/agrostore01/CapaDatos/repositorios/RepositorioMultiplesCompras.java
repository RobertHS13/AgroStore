package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;
import com.example.agrostore01.CapaEntidades.MultiplesCompras;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioMultiplesCompras extends Repositorio implements IContratoRelacion<MultiplesCompras> {

    public RepositorioMultiplesCompras(){
        this.sqlAlta = "insert into MultiplesCompras values (?)";
        this.sqlBaja = "delete from MultiplesCompras where IDNumProducto = ?";
        this.sqlCambio = "update MultiplesCompras set " +
                "IDNumProducto = ?," +
                "IDCarrito = ? " +
                "where IDNumProducto = ?";
        this.sqlSeleccionarId = "select * from MultiplesCompras where IDNumProducto = ?";
        this.sqlSeleccionarTodo = "select * from MultiplesCompras";
    }


    @Override
    public boolean alta(MultiplesCompras e) {
        parametros = new ArrayList<>();
        //parametros.add(e.getIdNumProducto());
        parametros.add(e.getIdCar());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, MultiplesCompras e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdNumProducto());
        parametros.add(e.getIdCar());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public MultiplesCompras seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            long IDNumProducto = resultado.getLong("IDNumProducto");
            long IDCarrito = resultado.getLong("IDCarrito");


            return new MultiplesCompras(IDNumProducto,IDCarrito);
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
    public ArrayList<MultiplesCompras> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<MultiplesCompras> multiplesCompras = new ArrayList<>();

        try {
            while (resultado.next()) {
                long IDNumProducto = resultado.getLong("IDNumProducto");
                long IDCarrito = resultado.getLong("IDCarrito");

                multiplesCompras.add(new MultiplesCompras(IDNumProducto,IDCarrito));
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
        return multiplesCompras;
    }

    @Override
    public boolean bajaEspecifica(MultiplesCompras e) {
        return false;
    }

    @Override
    public ArrayList<MultiplesCompras> seleccionarTodosId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);
        ArrayList<MultiplesCompras> multiplesCompras = new ArrayList<>();

        try {
            while (resultado.next()) {
                long IDNumProducto = resultado.getLong("IDNumProducto");
                long IDCarrito = resultado.getLong("IDCarrito");

                multiplesCompras.add(new MultiplesCompras(IDNumProducto,IDCarrito));
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
        return multiplesCompras;
    }

}

