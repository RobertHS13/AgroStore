package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class TerrenosUsuario extends Entidad implements Parcelable {

    private String idUsuario;
    private long idTerreno;

    public TerrenosUsuario() {
    }

    public TerrenosUsuario(String idUsuario, long idTerreno) {
        this.idUsuario = idUsuario;
        this.idTerreno = idTerreno;
    }

    protected TerrenosUsuario(Parcel in) {
        idUsuario = in.readString();
        idTerreno = in.readLong();
    }

    public static final Creator<TerrenosUsuario> CREATOR = new Creator<TerrenosUsuario>() {
        @Override
        public TerrenosUsuario createFromParcel(Parcel in) {
            return new TerrenosUsuario(in);
        }

        @Override
        public TerrenosUsuario[] newArray(int size) {
            return new TerrenosUsuario[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idUsuario);
        dest.writeLong(idTerreno);
    }
}
