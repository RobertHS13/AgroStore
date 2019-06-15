package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContratoProducto;
import com.example.agrostore01.CapaEntidades.Producto;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class RepositorioProducto extends Repositorio implements IContratoProducto {

    private String sqlProcBusquedaCategoria;
    private String sqlProcBusquedaNombre;
    private String sqlProcBusquedaFiltros;

    public RepositorioProducto(){
        this.sqlAlta = "insert into Producto values (?, ?, ?, ?, ?, ?)";
        this.sqlBaja = "delete from Producto where IDProducto = ?";
        this.sqlCambio = "update Producto set " +
                "IDProducto = ?," +
                "Producto = ?, " +
                "PrecioTonelada = ?, " +
                "PrecioKilogramo = ?, " +
                "Foto = ?, " +
                "Temporada = ?, " +
                "IDCategoria = ? " +
                "where IDProducto = ?";
        this.sqlSeleccionarId = "select * from Producto where IDProducto = ?";
        this.sqlSeleccionarTodo = "select * from Producto";

        this.sqlProcBusquedaCategoria = "{ call PROC_ESP_BUSQ_CATEGORIA(?) }";
        this.sqlProcBusquedaNombre = "{ call PROC_ESP_BUSQ_PRODUCTO(?) }";
        this.sqlProcBusquedaFiltros = "{ call PROC_ESP_FILTROS(?, ?, ?, ?, ?, ?, ?, ?) }";
    }

    @Override
    public boolean alta(Producto e) {
        parametros = new ArrayList<>();
        //parametros.add(e.getIdProducto());
        parametros.add(e.getProducto());
        parametros.add(e.getPrecioTonelada());
        parametros.add(e.getPrecioKilogramo());
        parametros.add(e.getFoto());
        parametros.add(e.getIdCategoria());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Producto e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdProducto());
        parametros.add(e.getProducto());
        parametros.add(e.getPrecioTonelada());
        parametros.add(e.getPrecioKilogramo());
        parametros.add(e.getFoto());
        parametros.add(e.getIdCategoria());
        parametros.add(id);
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public Producto seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            long IDProducto = resultado.getLong("IDProducto");
            String Producto = resultado.getString("Producto");
            BigDecimal precioTonelada= resultado.getBigDecimal("PrecioTonelada");
            BigDecimal precioKilogramo =resultado.getBigDecimal("PrecioKilogramo");
            byte[] foto = resultado.getBytes("Foto");
            boolean temporada= resultado.getBoolean("Temporada");
            int IDCategoria= resultado.getInt("IDCategoria");


            return new Producto(IDProducto,Producto,precioTonelada,foto,temporada,IDCategoria,precioKilogramo);
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
    public ArrayList<Producto> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            while (resultado.next()) {
                long IDProducto = resultado.getLong("IDProducto");
                String Producto = resultado.getString("Producto");
                BigDecimal precioTonelada= resultado.getBigDecimal("PrecioTonelada");
                BigDecimal precioKilogramo =resultado.getBigDecimal("PrecioKilogramo");
                byte[] foto = resultado.getBytes("Foto");
                boolean temporada= resultado.getBoolean("Temporada");
                int IDCategoria= resultado.getInt("IDCategoria");
                productos.add(new Producto(IDProducto,Producto,precioTonelada,foto,temporada,IDCategoria,precioKilogramo));
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
        return productos;
    }

    @Override
    public List<Integer> seleccionarIdProductosConCategoria(String categoria) {
        parametros = new ArrayList<>();
        parametros.add(categoria);

        resultado = ejecutarProcedimientoConSalida(sqlProcBusquedaCategoria);
        List<Integer> productos = new ArrayList<>();

        try {
            while (resultado.next()) {
                int idProducto = resultado.getInt("IDNumProducto");
                productos.add(idProducto);
            }
            return productos;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Integer> seleccionarIdProductosConNombre(String nombre) {
        parametros = new ArrayList<>();
        parametros.add(nombre);

        resultado = ejecutarProcedimientoConSalida(sqlProcBusquedaNombre);
        List<Integer> productos = new ArrayList<>();

        try {
            while (resultado.next()) {
                int idProducto = resultado.getInt("IDNumProducto");
                productos.add(idProducto);
            }
            return productos;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Integer> seleccionarIdProductosConFiltros(long precioMin, long precioMax, String producto,
                                                          String categoria, String temporada, String pais,
                                                          String estado, float estrellas) {
        parametros = new ArrayList<>();
        parametros.add(precioMin);
        parametros.add(precioMax);
        parametros.add(producto);
        parametros.add(categoria);
        parametros.add(temporada);
        parametros.add(pais);
        parametros.add(estado);
        parametros.add(estrellas);

        resultado = ejecutarProcedimientoConSalida(sqlProcBusquedaFiltros);
        List<Integer> productos = new ArrayList<>();

        try {
            while (resultado.next()) {
                int idProducto = resultado.getInt("IDNumProducto");
                productos.add(idProducto);
            }
            return productos;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
