package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Venta extends Entidad implements Parcelable {

    private long idVenta;
    private String idUsuarioAgricultor;
    private String idUsuarioCliente;
    private long idDetalle;

    public Venta() {
    }

    public Venta(String idUsuarioAgricultor, String idUsuarioCliente, long idDetalle) {
        this.idUsuarioAgricultor = idUsuarioAgricultor;
        this.idUsuarioCliente = idUsuarioCliente;
        this.idDetalle = idDetalle;
    }

    public Venta(long idVenta, String idUsuarioAgricultor, String idUsuarioCliente, long idDetalle) {
        this.idVenta = idVenta;
        this.idUsuarioAgricultor = idUsuarioAgricultor;
        this.idUsuarioCliente = idUsuarioCliente;
        this.idDetalle = idDetalle;
    }

    protected Venta(Parcel in) {
        idVenta = in.readLong();
        idUsuarioAgricultor = in.readString();
        idUsuarioCliente = in.readString();
        idDetalle = in.readLong();
    }

    public static final Creator<Venta> CREATOR = new Creator<Venta>() {
        @Override
        public Venta createFromParcel(Parcel in) {
            return new Venta(in);
        }

        @Override
        public Venta[] newArray(int size) {
            return new Venta[size];
        }
    };

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdUsuarioAgricultor() {
        return idUsuarioAgricultor;
    }

    public void setIdUsuarioAgricultor(String idUsuarioAgricultor) {
        this.idUsuarioAgricultor = idUsuarioAgricultor;
    }

    public String getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(String idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", idUsuarioAgricultor='" + idUsuarioAgricultor + '\'' +
                ", idUsuarioCliente='" + idUsuarioCliente + '\'' +
                ", idDetalle=" + idDetalle +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idVenta);
        dest.writeString(idUsuarioAgricultor);
        dest.writeString(idUsuarioCliente);
        dest.writeLong(idDetalle);
    }
}
