package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Timestamp;
import java.util.Arrays;

public class ProductoComprado extends Entidad implements Parcelable {

    private long idProdComprado;
    private long idTerreno;
    private byte[] localizacion;
    private java.sql.Timestamp tiempo;
    private boolean estado;

    public ProductoComprado() {
    }

    public ProductoComprado(long idTerreno, byte[] localizacion, Timestamp tiempo, boolean estado) {
        this.idTerreno = idTerreno;
        this.localizacion = localizacion;
        this.tiempo = tiempo;
        this.estado = estado;
    }

    public ProductoComprado(long idProdComprado, long idTerreno, byte[] localizacion, Timestamp tiempo, boolean estado) {
        this.idProdComprado = idProdComprado;
        this.idTerreno = idTerreno;
        this.localizacion = localizacion;
        this.tiempo = tiempo;
        this.estado = estado;
    }

    protected ProductoComprado(Parcel in) {
        idProdComprado = in.readLong();
        idTerreno = in.readLong();
        localizacion = in.createByteArray();
        estado = in.readByte() != 0;
    }

    public static final Creator<ProductoComprado> CREATOR = new Creator<ProductoComprado>() {
        @Override
        public ProductoComprado createFromParcel(Parcel in) {
            return new ProductoComprado(in);
        }

        @Override
        public ProductoComprado[] newArray(int size) {
            return new ProductoComprado[size];
        }
    };

    public long getIdProdComprado() {
        return idProdComprado;
    }

    public void setIdProdComprado(long idProdComprado) {
        this.idProdComprado = idProdComprado;
    }

    public long getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(long idTerreno) {
        this.idTerreno = idTerreno;
    }

    public byte[] getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(byte[] localizacion) {
        this.localizacion = localizacion;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ProductoComprado{" +
                "idProdComprado=" + idProdComprado +
                ", idTerreno=" + idTerreno +
                ", localizacion=" + Arrays.toString(localizacion) +
                ", tiempo=" + tiempo +
                ", estado=" + estado +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idProdComprado);
        dest.writeLong(idTerreno);
        dest.writeByteArray(localizacion);
        dest.writeByte((byte) (estado ? 1 : 0));
    }
}
