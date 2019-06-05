package com.example.agrostore01.CapaDatos.repositorios;


import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.DetalleVenta;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class RepositorioDetalleVenta extends Repositorio implements IContrato<DetalleVenta> {
    public RepositorioDetalleVenta(){
        this.sqlAlta="insert into DetalleVenta values(?,?,?,?,?)";
        this.sqlBaja="delete from DetalleVenta where IDDEtalle = ?";
        this.sqlCambio="update DetalleVenta set" +
                "IDDetalle = ?," +
                "Producto = ?," +
                "Precio = ?," +
                "IDTerreno = ?," +
                "Fecha = ?," +
                "Tamaño = ?" +
                "where IDDetalle = ?";
        this.sqlSeleccionarId="select * from DetalleVenta where IDDetalle = ?";
        this.sqlSeleccionarTodo="select * from DetalleVenta";
    }


    @Override
    public boolean alta(DetalleVenta e) {

        parametros = new ArrayList<>();
       // parametros.add(e.getIdDetalle());
        parametros.add(e.getProducto());
        parametros.add(e.getPrecioTonelada());
        parametros.add(e.getIdTerreno());
        parametros.add(e.getFecha());
        parametros.add(e.getTamaño());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {

        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, DetalleVenta e) {


        parametros = new ArrayList<>();
        parametros.add(e.getIdDetalle());
        parametros.add(e.getProducto());
        parametros.add(e.getPrecioTonelada());
        parametros.add(e.getIdTerreno());
        parametros.add(e.getFecha());
        parametros.add(e.getTamaño());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public DetalleVenta seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            long IDDetalle = resultado.getLong("IDDetalle");
            String Producto = resultado.getString("Producto");
            BigDecimal Precio = resultado.getBigDecimal("Precio");
            long IDTerreno = resultado.getLong("IDTerreno");
            Timestamp Fecha = resultado.getTimestamp("Fecha");
            int Tamaño = resultado.getInt("Tamaño");
            return new DetalleVenta(IDDetalle,Producto,Precio,IDTerreno,Fecha,Tamaño);
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
    public ArrayList<DetalleVenta> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<DetalleVenta> detalleVentas = new ArrayList<>();

        try {
            while (resultado.next()) {
                long IDDetalle = resultado.getLong("IDDetalle");
                String Producto = resultado.getString("Producto");
                BigDecimal Precio = resultado.getBigDecimal("Precio");
                long IDTerreno = resultado.getLong("IDTerreno");
                Timestamp Fecha = resultado.getTimestamp("Fecha");
                int Tamaño = resultado.getInt("Tamaño");
                detalleVentas.add(new DetalleVenta(IDDetalle,Producto,Precio,IDTerreno,Fecha,Tamaño));
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
        return detalleVentas;
    }
    }
