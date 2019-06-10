package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class ProductoTerreno extends Entidad implements Parcelable {

    private long idNumProduc;
    private long idProducto;
    private long idTerreno;
    private java.math.BigDecimal precio;
    private int hectareas;
    private String descripcion;

    public ProductoTerreno() {}

    public ProductoTerreno(long idNumProduc, long idProducto, long idTerreno, BigDecimal precio, int hectareas, String descripcion) {
        this.idNumProduc = idNumProduc;
        this.idProducto = idProducto;
        this.idTerreno = idTerreno;
        this.precio = precio;
        this.hectareas = hectareas;
        this.descripcion = descripcion;
    }

    protected ProductoTerreno(Parcel in) {
        idNumProduc = in.readLong();
        idProducto = in.readLong();
        idTerreno = in.readLong();
        hectareas = in.readInt();
        descripcion = in.readString();
    }

    public static final Creator<ProductoTerreno> CREATOR = new Creator<ProductoTerreno>() {
        @Override
        public ProductoTerreno createFromParcel(Parcel in) {
            return new ProductoTerreno(in);
        }

        @Override
        public ProductoTerreno[] newArray(int size) {
            return new ProductoTerreno[size];
        }
    };

    public long getIdNumProduc() {
        return idNumProduc;
    }

    public void setIdNumProduc(long idNumProduc) {
        this.idNumProduc = idNumProduc;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public long getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(long idTerreno) {
        this.idTerreno = idTerreno;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getHectareas() {
        return hectareas;
    }

    public void setHectareas(int hectareas) {
        this.hectareas = hectareas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idNumProduc);
        dest.writeLong(idProducto);
        dest.writeLong(idTerreno);
        dest.writeInt(hectareas);
        dest.writeString(descripcion);
    }
}
