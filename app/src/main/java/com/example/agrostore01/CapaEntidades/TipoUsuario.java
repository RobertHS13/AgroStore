package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class TipoUsuario extends Entidad implements Parcelable {

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

    protected TipoUsuario(Parcel in) {
        idTipo = in.readInt();
        tipoUsuario = in.readString();
    }

    public static final Creator<TipoUsuario> CREATOR = new Creator<TipoUsuario>() {
        @Override
        public TipoUsuario createFromParcel(Parcel in) {
            return new TipoUsuario(in);
        }

        @Override
        public TipoUsuario[] newArray(int size) {
            return new TipoUsuario[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idTipo);
        dest.writeString(tipoUsuario);
    }
}
