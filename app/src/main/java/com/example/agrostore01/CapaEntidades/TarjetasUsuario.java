package com.example.agrostore01.CapaEntidades;

public class TarjetasUsuario {

    private String numTarjeta;
    private String idUsuario;

    public TarjetasUsuario() {
    }

    public TarjetasUsuario(String numTarjeta, String idUsuario) {
        this.numTarjeta = numTarjeta;
        this.idUsuario = idUsuario;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "TarjetasUsuario{" +
                "numTarjeta='" + numTarjeta + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }
}
