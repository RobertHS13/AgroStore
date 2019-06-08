package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContratoRelacion;
import com.example.agrostore01.CapaEntidades.TarjetasUsuario;

import java.util.ArrayList;

public class RepositorioTarjetasUsuario extends Repositorio implements IContratoRelacion<TarjetasUsuario> {

    public RepositorioTarjetasUsuario(){
        this.sqlAlta = "insert into TarjetasUsuario values (?, ?)";
        this.sqlBaja = "delete from TarjetasUsuario where IDTarjeta = ?";
        this.sqlCambio = "update TarjetasUsuario set " +
                "IDTarjeta = ?," +
                "IDUsuario = ? " +
                "where IDTarjeta = ?";
        this.sqlSeleccionarId = "select * from TarjetasUsuario where IDTarjeta = ?";
        this.sqlSeleccionarTodo = "select * from TarjetasUsuario";

    }

    @Override
    public boolean alta(TarjetasUsuario e) {
        parametros= new ArrayList<>();
        parametros.add(e.getNumTarjeta());
        parametros.add(e.getIdUsuario());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, TarjetasUsuario e) {
        parametros= new ArrayList<>();
        parametros.add(e.getNumTarjeta());
        parametros.add(e.getIdUsuario());
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public TarjetasUsuario seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            String idTarjeta= resultado.getString("IDTarjeta");
            String idUsuario=resultado.getString("IDUsuario");

            return new TarjetasUsuario(idTarjeta,idUsuario);
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
    public ArrayList<TarjetasUsuario> seleccionarTodo() {

        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<TarjetasUsuario> tarjetasUsuarios = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idTarjeta= resultado.getString("IDTarjeta");
                String idUsuario=resultado.getString("IDUsuario");
                tarjetasUsuarios.add(new TarjetasUsuario(idTarjeta,idUsuario));
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
        return tarjetasUsuarios;
    }

    @Override
    public boolean bajaEspecifica(TarjetasUsuario e) {
        return false;
    }

    @Override
    public ArrayList<TarjetasUsuario> seleccionarTodosId(Object id) {

        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);
        ArrayList<TarjetasUsuario> tarjetasUsuarios = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idTarjeta= resultado.getString("IDTarjeta");
                String idUsuario=resultado.getString("IDUsuario");
                tarjetasUsuarios.add(new TarjetasUsuario(idTarjeta,idUsuario));
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
        return tarjetasUsuarios;
    }
}
