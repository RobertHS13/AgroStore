package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class CompraUsuario extends Entidad implements Parcelable {

    private String idUsuario;
    private long idProductoComprado;

    public CompraUsuario() {
    }

    public CompraUsuario(String idUsuario, long idProductoComprado) {
        this.idUsuario = idUsuario;
        this.idProductoComprado = idProductoComprado;
    }

    protected CompraUsuario(Parcel in) {
        idUsuario = in.readString();
        idProductoComprado = in.readLong();
    }

    public static final Creator<CompraUsuario> CREATOR = new Creator<CompraUsuario>() {
        @Override
        public CompraUsuario createFromParcel(Parcel in) {
            return new CompraUsuario(in);
        }

        @Override
        public CompraUsuario[] newArray(int size) {
            return new CompraUsuario[size];
        }
    };

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdProductoComprado() {
        return idProductoComprado;
    }

    public void setIdProductoComprado(long idProductoComprado) {
        this.idProductoComprado = idProductoComprado;
    }

    @Override
    public String toString() {
        return "CompraUsuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", idProductoComprado=" + idProductoComprado +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idUsuario);
        dest.writeLong(idProductoComprado);
    }
}
