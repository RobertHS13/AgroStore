package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Tarjetas extends Entidad implements Parcelable {

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

    protected Tarjetas(Parcel in) {
        numTarjeta = in.readString();
        cdv = in.readString();
        mes = in.readString();
        año = in.readString();
    }

    public static final Creator<Tarjetas> CREATOR = new Creator<Tarjetas>() {
        @Override
        public Tarjetas createFromParcel(Parcel in) {
            return new Tarjetas(in);
        }

        @Override
        public Tarjetas[] newArray(int size) {
            return new Tarjetas[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numTarjeta);
        dest.writeString(cdv);
        dest.writeString(mes);
        dest.writeString(año);
    }
}
