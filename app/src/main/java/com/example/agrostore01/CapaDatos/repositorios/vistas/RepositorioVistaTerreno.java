package com.example.agrostore01.CapaDatos.repositorios.vistas;

import com.example.agrostore01.CapaDatos.contratos.vistas.IContratoVistaTerreno;
import com.example.agrostore01.CapaDatos.repositorios.Repositorio;
import com.example.agrostore01.CapaEntidades.vistas.VistaTerreno;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVistaTerreno extends Repositorio implements IContratoVistaTerreno {

    private String sqlProcMisTerrenos;

    public RepositorioVistaTerreno() {
        this.sqlProcMisTerrenos = "{ call PROC_ESP_MISTEERENOS(?) }";
    }

    @Override
    public List<VistaTerreno> seleccionarTerrenos(String idUsuario) {

        try {
            parametros = new ArrayList<>();
            parametros.add(idUsuario);

            List<VistaTerreno> terrenos = new ArrayList<>();

            resultado = ejecutarProcedimientoConSalida(sqlProcMisTerrenos);

            while (resultado.next()) {

                int idTerreno = resultado.getInt("IDTerreno");
                String medida = resultado.getString("Medida");
                float tamano = resultado.getFloat("Tamaño");
                String tipo = resultado.getString("Tipo");

                terrenos.add(new VistaTerreno(idTerreno, medida, tamano, tipo));
            }

            return terrenos;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean alta(VistaTerreno e) {
        return false;
    }

    @Override
    public boolean baja(Object id) {
        return false;
    }

    @Override
    public boolean cambio(Object id, VistaTerreno e) {
        return false;
    }

    @Override
    public VistaTerreno seleccionarId(Object id) {
        return null;
    }

    @Override
    public ArrayList<VistaTerreno> seleccionarTodo() {
        return null;
    }
}
