package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.TarjetasUsuario;

import java.util.ArrayList;

public class RepositorioTarjetasUsuario extends Repositorio implements IContrato<TarjetasUsuario> {

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
        //parametros.add(e.getNumTarjeta());
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
        return null;
    }

    @Override
    public ArrayList<TarjetasUsuario> seleccionarTodo() {
        return null;
    }
}
