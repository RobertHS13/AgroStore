package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.ProductoComprado;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class RepositorioProductoCompra extends Repositorio implements IContrato<ProductoComprado> {
    public RepositorioProductoCompra(){
        this.sqlAlta = "insert into ProductoComprado values (?,?)";
        this.sqlBaja = "delete from ProductoComprado where IDprodComprado = ?";
        this.sqlCambio = "update ProductoComprado set" +
                "IDprodComprado  = ?," +
                "IDTerreno= ?," +
                "Localizacion= ?," +
                "Tiempo= ?," +
                "Estado= ?" +
                "where IDprodComprado = ?";
        this.sqlSeleccionarId = "select * from ProductoComprado where IDprodComprado = ?";
        this.sqlSeleccionarTodo = "select * from ProductoComprado";
    }

    @Override
    public boolean alta(ProductoComprado e) {
        parametros = new ArrayList<>();
        //parametros.add(e.getIdProdComprado());
        parametros.add(e.getIdTerreno());
        parametros.add(e.getLocalizacion());
        parametros.add(e.getTiempo());
        parametros.add(e.isEstado());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, ProductoComprado e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdProdComprado());
        parametros.add(e.getIdTerreno());
        parametros.add(e.getLocalizacion());
        parametros.add(e.getTiempo());
        parametros.add(e.isEstado());
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public ProductoComprado seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            long idProductocomprado = resultado.getLong("IDProductoComprado");
            long idterreno = resultado.getLong("IDTerreno");
            byte[] localizacion = resultado.getBytes("Localizacion");
            Timestamp tiempo = resultado.getTimestamp("Tiempo");
            boolean estado = resultado.getBoolean("Estado");
            return new ProductoComprado(idProductocomprado,idterreno,localizacion,tiempo,estado);
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
    public ArrayList<ProductoComprado> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<ProductoComprado> productoComprados = new ArrayList<>();

        try {
            while (resultado.next()) {
                long idProductocomprado = resultado.getLong("IDProductoComprado");
                long idterreno = resultado.getLong("IDTerreno");
                byte[] localizacion = resultado.getBytes("Localizacion");
                Timestamp tiempo = resultado.getTimestamp("Tiempo");
                boolean estado = resultado.getBoolean("Estado");
                productoComprados.add(new ProductoComprado(idProductocomprado,idterreno,localizacion,tiempo,estado));
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
        return productoComprados;
    }
}
