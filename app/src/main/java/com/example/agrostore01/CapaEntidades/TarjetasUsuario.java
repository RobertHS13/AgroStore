package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class TarjetasUsuario extends Entidad implements Parcelable {

    private String numTarjeta;
    private String idUsuario;

    public TarjetasUsuario() {
    }

    public TarjetasUsuario(String numTarjeta, String idUsuario) {
        this.numTarjeta = numTarjeta;
        this.idUsuario = idUsuario;
    }

    protected TarjetasUsuario(Parcel in) {
        numTarjeta = in.readString();
        idUsuario = in.readString();
    }

    public static final Creator<TarjetasUsuario> CREATOR = new Creator<TarjetasUsuario>() {
        @Override
        public TarjetasUsuario createFromParcel(Parcel in) {
            return new TarjetasUsuario(in);
        }

        @Override
        public TarjetasUsuario[] newArray(int size) {
            return new TarjetasUsuario[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numTarjeta);
        dest.writeString(idUsuario);
    }
}
