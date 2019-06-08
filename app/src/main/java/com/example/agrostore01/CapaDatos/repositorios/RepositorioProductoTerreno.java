package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;
import com.example.agrostore01.CapaEntidades.ProductoTerreno;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioProductoTerreno extends Repositorio implements IContratoRelacion<ProductoTerreno> {

    public RepositorioProductoTerreno(){
        this.sqlAlta = "insert into ProductoTerreno values (?, ?)";
        this.sqlBaja = "delete from ProductoTerreno where IDNumProducto = ?";
        this.sqlCambio = "update ProductoTerreno set " +
                "IDNumProducto = ?," +
                "IDProducto = ?, " +
                "IDTerreno = ? " +
                "where IDNumProducto= ?";
        this.sqlSeleccionarId = "select * from ProductoTerreno where IDNumProducto = ?";
        this.sqlSeleccionarTodo = "select * from ProductoTerreno";

    }
    @Override
    public boolean alta(ProductoTerreno e) {
        parametros = new ArrayList<>();
        //parametros.add(e.getIdNumProduc());
        parametros.add(e.getIdProducto());
        parametros.add(e.getIdTerreno());
        return ejecutarConsulta(sqlAlta);

    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, ProductoTerreno e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdNumProduc());
        parametros.add(e.getIdProducto());
        parametros.add(e.getIdTerreno());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public ProductoTerreno seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            long idnumprod= resultado.getLong("IDNumProducto");
            long idproducto = resultado.getLong("IDProducto");
            long idterreno =resultado.getLong("IDTerreno");

            return new ProductoTerreno(idnumprod,idproducto,idterreno);
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
    public ArrayList<ProductoTerreno> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<ProductoTerreno> productoTerrenos = new ArrayList<>();

        try {
            while (resultado.next()) {
                long idnumprod= resultado.getLong("IDNumProducto");
                long idproducto = resultado.getLong("IDProducto");
                long idterreno =resultado.getLong("IDTerreno");
                productoTerrenos.add(new ProductoTerreno(idnumprod,idproducto,idterreno));
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
        return productoTerrenos;
    }

    @Override
    public boolean bajaEspecifica(ProductoTerreno e) {
        return false;
    }

    @Override
    public ArrayList<ProductoTerreno> seleccionarTodosId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);
        ArrayList<ProductoTerreno> productoTerrenos = new ArrayList<>();

        try {
            while (resultado.next()) {
                long idnumprod= resultado.getLong("IDNumProducto");
                long idproducto = resultado.getLong("IDProducto");
                long idterreno =resultado.getLong("IDTerreno");
                productoTerrenos.add(new ProductoTerreno(idnumprod,idproducto,idterreno));
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
        return productoTerrenos;
    }

}
