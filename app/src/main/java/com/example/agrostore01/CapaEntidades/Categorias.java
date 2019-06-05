package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Categorias extends Entidad implements Parcelable {

    private int idCategoria;
    private String nombre;

    public Categorias() { }

    public Categorias(String nombre) {
        this.nombre = nombre;
    }

    public Categorias(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    protected Categorias(Parcel in) {
        idCategoria = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<Categorias> CREATOR = new Creator<Categorias>() {
        @Override
        public Categorias createFromParcel(Parcel in) {
            return new Categorias(in);
        }

        @Override
        public Categorias[] newArray(int size) {
            return new Categorias[size];
        }
    };

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idCategoria);
        dest.writeString(nombre);
    }
}
