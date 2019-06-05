package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.Tarjetas;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioTarjetas extends Repositorio implements IContrato<Tarjetas> {
    public RepositorioTarjetas(){
        this.sqlAlta= "insert into Targeta values (?,?,?,?)";
        this.sqlBaja= "delete from Targeta where IDTargeta = ?";
        this.sqlCambio= "update Targeta set " +
                "IDTargeta = ?," +
                "NumTargeta = ?," +
                "CDV = ?," +
                "Mes = ?," +
                "Año = ?" +
                "where IDTargeta = ?";
        this.sqlSeleccionarId="select * from Targeta where IDTargeta = ?";
        this.sqlSeleccionarTodo="select * from Targeta";
    }
    @Override
    public boolean alta(Tarjetas e) {

        parametros = new ArrayList<>();
        parametros.add(e.getNumTarjeta());
        parametros.add(e.getCdv());
        parametros.add(e.getMes());
        parametros.add(e.getAño());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Tarjetas e) {
        parametros = new ArrayList<>();
        parametros.add(e.getNumTarjeta());
        parametros.add(e.getCdv());
        parametros.add(e.getMes());
        parametros.add(e.getAño());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public Tarjetas seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            //int IDTargeta = resgultado.getString("IDTargeta");
            String numTarjeta = resultado.getString("NumTargeta");
            String cdv = resultado.getString("CDV");
            String mes = resultado.getString("Mes");
            String año = resultado.getString("Año");


            return new Tarjetas(/*IDTargeta*/numTarjeta,cdv,mes,año);
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
    public ArrayList<Tarjetas> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Tarjetas> tarjetas = new ArrayList<>();

        try {
            while (resultado.next()) {
                //int IDTargeta = resgultado.getString("IDTargeta");
                String numTarjeta = resultado.getString("NumTargeta");
                String cdv = resultado.getString("CDV");
                String mes = resultado.getString("Mes");
                String año = resultado.getString("Año");

                tarjetas.add(new Tarjetas(/*IDTargeta*/numTarjeta,cdv,mes,año));
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
        return tarjetas;
    }
    }

