package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductoTerreno extends Entidad implements Parcelable {

    private long idNumProduc;
    private long idProducto;
    private long idTerreno;

    public ProductoTerreno() {
    }

    public ProductoTerreno(long idProducto, long idTerreno) {
        this.idProducto = idProducto;
        this.idTerreno = idTerreno;
    }

    public ProductoTerreno(long idNumProduc, long idProducto, long idTerreno) {
        this.idNumProduc = idNumProduc;
        this.idProducto = idProducto;
        this.idTerreno = idTerreno;
    }

    protected ProductoTerreno(Parcel in) {
        idNumProduc = in.readLong();
        idProducto = in.readLong();
        idTerreno = in.readLong();
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

    @Override
    public String toString() {
        return "ProductoTerreno{" +
                "idNumProduc=" + idNumProduc +
                ", idProducto=" + idProducto +
                ", idTerreno=" + idTerreno +
                '}';
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
    }
}
