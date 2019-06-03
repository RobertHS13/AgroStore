package com.example.agrostore01.CapaEntidades;

public class ProductoTerreno {
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
}
