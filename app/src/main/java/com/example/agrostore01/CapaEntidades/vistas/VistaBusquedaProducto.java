package com.example.agrostore01.CapaEntidades.vistas;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.Arrays;

public class VistaBusquedaProducto implements Parcelable {

    private String producto;
    private String nombreUsuario;
    private String apellidosUsuario;
    private byte[] foto;
    private BigDecimal precio;
    private int hectareas;
    private String descripcion;
    private String estado;
    private String ciudad;

    public VistaBusquedaProducto() {}

    public VistaBusquedaProducto(String producto, String nombreUsuario, String apellidosUsuario, byte[] foto, BigDecimal precio, int hectareas, String descripcion, String estado, String ciudad) {
        this.producto = producto;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.foto = foto;
        this.precio = precio;
        this.hectareas = hectareas;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ciudad = ciudad;
    }

    protected VistaBusquedaProducto(Parcel in) {
        producto = in.readString();
        nombreUsuario = in.readString();
        apellidosUsuario = in.readString();
        foto = in.createByteArray();
        hectareas = in.readInt();
        descripcion = in.readString();
        estado = in.readString();
        ciudad = in.readString();
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(producto);
        dest.writeString(nombreUsuario);
        dest.writeString(apellidosUsuario);
        dest.writeByteArray(foto);
        dest.writeInt(hectareas);
        dest.writeString(descripcion);
        dest.writeString(estado);
        dest.writeString(ciudad);
    }
}
