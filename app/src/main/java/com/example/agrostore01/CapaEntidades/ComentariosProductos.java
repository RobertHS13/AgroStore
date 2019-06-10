package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class ComentariosProductos implements Parcelable {

    private long idComentarios;
    private int idProductoTerreno;

    public ComentariosProductos() {}

    public ComentariosProductos(long idComentarios, int idProductoTerreno) {
        this.idComentarios = idComentarios;
        this.idProductoTerreno = idProductoTerreno;
    }

    protected ComentariosProductos(Parcel in) {
        idComentarios = in.readLong();
        idProductoTerreno = in.readInt();
    }

    public static final Creator<ComentariosProductos> CREATOR = new Creator<ComentariosProductos>() {
        @Override
        public ComentariosProductos createFromParcel(Parcel in) {
            return new ComentariosProductos(in);
        }

        @Override
        public ComentariosProductos[] newArray(int size) {
            return new ComentariosProductos[size];
        }
    };

    public long getIdComentarios() {
        return idComentarios;
    }

    public void setIdComentarios(long idComentarios) {
        this.idComentarios = idComentarios;
    }

    public int getIdProductoTerreno() {
        return idProductoTerreno;
    }

    public void setIdProductoTerreno(int idProductoTerreno) {
        this.idProductoTerreno = idProductoTerreno;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idComentarios);
        dest.writeInt(idProductoTerreno);
    }
}
