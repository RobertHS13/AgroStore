package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Carrito extends Entidad implements Parcelable {

    private long idCar;
    private String idUsuario;

    public Carrito() { }

    public Carrito(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Carrito(long idCar, String idUsuario) {
        this.idCar = idCar;
        this.idUsuario = idUsuario;
    }

    protected Carrito(Parcel in) {
        idCar = in.readLong();
        idUsuario = in.readString();
    }

    public static final Creator<Carrito> CREATOR = new Creator<Carrito>() {
        @Override
        public Carrito createFromParcel(Parcel in) {
            return new Carrito(in);
        }

        @Override
        public Carrito[] newArray(int size) {
            return new Carrito[size];
        }
    };

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "idCar=" + idCar +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idCar);
        dest.writeString(idUsuario);
    }
}
