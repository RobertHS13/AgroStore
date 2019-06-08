package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.Terreno;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioTerreno extends Repositorio implements IContrato<Terreno> {

    public RepositorioTerreno(){
        this.sqlAlta = "insert into Terreno values (?, ?, ?)";
        this.sqlBaja = "delete from Terreno where IDTerreno = ?";
        this.sqlCambio = "update Terreno set " +
                "IDTerreno = ?," +
                "Tamaño = ?, " +
                "Medida = ?, " +
                "Tipo = ?, " +
                "where IDTerreno = ?";
        this.sqlSeleccionarId = "select * from Terreno where IDTerreno = ?";
        this.sqlSeleccionarTodo = "select * from Terreno";
    }

    @Override
    public boolean alta(Terreno e) {
        parametros= new ArrayList<>();
        parametros.add(e.getTamaño());
        parametros.add(e.getMedida());
        parametros.add(e.getTipo());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Terreno e) {
        parametros= new ArrayList<>();
        parametros.add(e.getIdTerreno());
        parametros.add(e.getTamaño());
        parametros.add(e.getMedida());
        parametros.add(e.getTipo());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public Terreno seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            long idTerreno = resultado.getLong("IDTerreno");
            int tamaño = resultado.getInt("Tamaño");
            String medida = resultado.getString("Medida");
            String tipo = resultado.getString("Tipo");
            return new Terreno(idTerreno,tamaño,medida,tipo);
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
    public ArrayList<Terreno> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Terreno> terrenos = new ArrayList<>();

        try {
            while (resultado.next()) {
                long idTerreno = resultado.getLong("IDTerreno");
                int tamaño = resultado.getInt("Tamaño");
                String medida = resultado.getString("Medida");
                String tipo = resultado.getString("Tipo");
                terrenos.add(new Terreno(idTerreno,tamaño,medida,tipo));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return terrenos;
    }
}
