package com.example.agrostore01.CapaEntidades;

public class TipoUsuario {

    private int idTipo;
    private String tipoUsuario;

    public TipoUsuario() {
    }

    public TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuario(int idTipo, String tipoUsuario) {
        this.idTipo = idTipo;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "EscritorTipoUsuario{" +
                "idTipo=" + idTipo +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
