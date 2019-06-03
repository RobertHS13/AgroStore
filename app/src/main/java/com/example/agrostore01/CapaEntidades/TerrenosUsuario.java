package com.example.agrostore01.CapaEntidades;

public class TerrenosUsuario {
    private String idUsuario;
    private long idTerreno;

    public TerrenosUsuario() {
    }

    public TerrenosUsuario(String idUsuario, long idTerreno) {
        this.idUsuario = idUsuario;
        this.idTerreno = idTerreno;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(long idTerreno) {
        this.idTerreno = idTerreno;
    }

    @Override
    public String toString() {
        return "TerrenosUsuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", idTerreno=" + idTerreno +
                '}';
    }
}
