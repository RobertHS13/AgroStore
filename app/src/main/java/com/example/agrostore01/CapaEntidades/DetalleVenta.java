package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DetalleVenta extends Entidad implements Parcelable {

    private long idDetalle;
    private String producto;
    private java.math.BigDecimal precioTonelada;
    private long idTerreno;
    private java.sql.Timestamp fecha;
    private int tamaño;

    public DetalleVenta() {
    }

    public DetalleVenta(String producto, BigDecimal precioTonelada, long idTerreno, Timestamp fecha, int tamaño) {
        this.producto = producto;
        this.precioTonelada = precioTonelada;
        this.idTerreno = idTerreno;
        this.fecha = fecha;
        this.tamaño = tamaño;
    }

    public DetalleVenta(long idDetalle, String producto, BigDecimal precioTonelada, long idTerreno, Timestamp fecha, int tamaño) {
        this.idDetalle = idDetalle;
        this.producto = producto;
        this.precioTonelada = precioTonelada;
        this.idTerreno = idTerreno;
        this.fecha = fecha;
        this.tamaño = tamaño;
    }

    protected DetalleVenta(Parcel in) {
        idDetalle = in.readLong();
        producto = in.readString();
        idTerreno = in.readLong();
        tamaño = in.readInt();
    }

    public static final Creator<DetalleVenta> CREATOR = new Creator<DetalleVenta>() {
        @Override
        public DetalleVenta createFromParcel(Parcel in) {
            return new DetalleVenta(in);
        }

        @Override
        public DetalleVenta[] newArray(int size) {
            return new DetalleVenta[size];
        }
    };

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecioTonelada() {
        return precioTonelada;
    }

    public void setPrecioTonelada(BigDecimal precioTonelada) {
        this.precioTonelada = precioTonelada;
    }

    public long getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(long idTerreno) {
        this.idTerreno = idTerreno;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalle=" + idDetalle +
                ", producto='" + producto + '\'' +
                ", precioTonelada=" + precioTonelada +
                ", idTerreno=" + idTerreno +
                ", fecha=" + fecha +
                ", tamaño=" + tamaño +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idDetalle);
        dest.writeString(producto);
        dest.writeLong(idTerreno);
        dest.writeInt(tamaño);
    }
}