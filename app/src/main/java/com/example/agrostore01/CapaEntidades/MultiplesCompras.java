package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class MultiplesCompras extends Entidad implements Parcelable {

    private long idNumProducto;
    private long idCar;

    public MultiplesCompras() {
    }

    public MultiplesCompras(long idNumProducto, long idCar) {
        this.idNumProducto = idNumProducto;
        this.idCar = idCar;
    }

    protected MultiplesCompras(Parcel in) {
        idNumProducto = in.readLong();
        idCar = in.readLong();
    }

    public static final Creator<MultiplesCompras> CREATOR = new Creator<MultiplesCompras>() {
        @Override
        public MultiplesCompras createFromParcel(Parcel in) {
            return new MultiplesCompras(in);
        }

        @Override
        public MultiplesCompras[] newArray(int size) {
            return new MultiplesCompras[size];
        }
    };

    public long getIdNumProducto() {
        return idNumProducto;
    }

    public void setIdNumProducto(long idNumProducto) {
        this.idNumProducto = idNumProducto;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    @Override
    public String toString() {
        return "MultiplesCompras{" +
                "idNumProducto=" + idNumProducto +
                ", idCar=" + idCar +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idNumProducto);
        dest.writeLong(idCar);
    }
}
