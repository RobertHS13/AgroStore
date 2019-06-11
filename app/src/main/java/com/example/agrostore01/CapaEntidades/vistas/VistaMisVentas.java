package com.example.agrostore01.CapaEntidades.vistas;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class VistaMisVentas implements Parcelable {

    private int numeroDeVenta;
    private BigDecimal precio;
    private String producto;
    private String fecha;

    public VistaMisVentas(int numeroDeVenta, BigDecimal precio, String producto, String fecha) {
        this.numeroDeVenta = numeroDeVenta;
        this.precio = precio;
        this.producto = producto;
        this.fecha = fecha;
    }

    protected VistaMisVentas(Parcel in) {
        numeroDeVenta = in.readInt();
        producto = in.readString();
        fecha = in.readString();
    }

    public static final Creator<VistaMisVentas> CREATOR = new Creator<VistaMisVentas>() {
        @Override
        public VistaMisVentas createFromParcel(Parcel in) {
            return new VistaMisVentas(in);
        }

        @Override
        public VistaMisVentas[] newArray(int size) {
            return new VistaMisVentas[size];
        }
    };

    public int getNumeroDeVenta() {
        return numeroDeVenta;
    }

    public void setNumeroDeVenta(int numeroDeVenta) {
        this.numeroDeVenta = numeroDeVenta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "VistaMisVentas{" +
                "numeroDeVenta=" + numeroDeVenta +
                ", precio=" + precio +
                ", producto='" + producto + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numeroDeVenta);
        dest.writeString(producto);
        dest.writeString(fecha);
    }
}
