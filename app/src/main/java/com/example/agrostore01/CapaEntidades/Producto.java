package com.example.agrostore01.CapaEntidades;

import java.math.BigDecimal;
import java.util.Arrays;

public class Producto {
    private long idProducto;
    private String producto;
    private java.math.BigDecimal precioTonelada;
    private byte[] foto;
    private boolean temporada;
    private int idCategoria;
    private java.math.BigDecimal precioKilogramo;

    public Producto() {
    }

    public Producto(String producto, BigDecimal precioTonelada, byte[] foto, boolean temporada, int idCategoria, BigDecimal precioKilogramo) {
        this.producto = producto;
        this.precioTonelada = precioTonelada;
        this.foto = foto;
        this.temporada = temporada;
        this.idCategoria = idCategoria;
        this.precioKilogramo = precioKilogramo;
    }

    public Producto(long idProducto, String producto, BigDecimal precioTonelada, byte[] foto, boolean temporada, int idCategoria, BigDecimal precioKilogramo) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.precioTonelada = precioTonelada;
        this.foto = foto;
        this.temporada = temporada;
        this.idCategoria = idCategoria;
        this.precioKilogramo = precioKilogramo;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public boolean isTemporada() {
        return temporada;
    }

    public void setTemporada(boolean temporada) {
        this.temporada = temporada;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getPrecioKilogramo() {
        return precioKilogramo;
    }

    public void setPrecioKilogramo(BigDecimal precioKilogramo) {
        this.precioKilogramo = precioKilogramo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", producto='" + producto + '\'' +
                ", precioTonelada=" + precioTonelada +
                ", foto=" + Arrays.toString(foto) +
                ", temporada=" + temporada +
                ", idCategoria=" + idCategoria +
                ", precioKilogramo=" + precioKilogramo +
                '}';
    }
}
