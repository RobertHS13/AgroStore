package com.example.agrostore01.CapaEntidades;

public class Tarjetas {

    private String numTarjeta;
    private String cdv;
    private String mes;
    private String año;

    public Tarjetas() {
    }

    public Tarjetas(String cdv, String mes, String año) {
        this.cdv = cdv;
        this.mes = mes;
        this.año = año;
    }

    public Tarjetas(String numTarjeta, String cdv, String mes, String año) {
        this.numTarjeta = numTarjeta;
        this.cdv = cdv;
        this.mes = mes;
        this.año = año;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getCdv() {
        return cdv;
    }

    public void setCdv(String cdv) {
        this.cdv = cdv;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Tarjetas{" +
                "numTarjeta='" + numTarjeta + '\'' +
                ", cdv='" + cdv + '\'' +
                ", mes='" + mes + '\'' +
                ", año='" + año + '\'' +
                '}';
    }
}
