package com.example.agrostore01.CapaEntidades.vistas;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.Arrays;

public class VistaBusquedaProducto implements Parcelable {

    private String producto;
    private byte[] foto;
    private BigDecimal precio;
    private int hectareas;
    private String estado;
    private String ciudad;

    public VistaBusquedaProducto() {}

    public VistaBusquedaProducto(String producto, byte[] foto, BigDecimal precio, int hectareas, String estado, String ciudad) {
        this.producto = producto;
        this.foto = foto;
        this.precio = precio;
        this.hectareas = hectareas;
        this.estado = estado;
        this.ciudad = ciudad;
    }

    protected VistaBusquedaProducto(Parcel in) {
        producto = in.readString();
        foto = in.createByteArray();
        hectareas = in.readInt();
        estado = in.readString();
        ciudad = in.readString();
    }

    public static final Creator<VistaBusquedaProducto> CREATOR = new Creator<VistaBusquedaProducto>() {
        @Override
        public VistaBusquedaProducto createFromParcel(Parcel in) {
            return new VistaBusquedaProducto(in);
        }

        @Override
        public VistaBusquedaProducto[] newArray(int size) {
            return new VistaBusquedaProducto[size];
        }
    };

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "VistaBusquedaProducto{" +
                "producto='" + producto + '\'' +
                ", foto=" + Arrays.toString(foto) +
                ", precio=" + precio +
                ", hectareas=" + hectareas +
                ", estado='" + estado + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(producto);
        dest.writeByteArray(foto);
        dest.writeInt(hectareas);
        dest.writeString(estado);
        dest.writeString(ciudad);
    }
}
