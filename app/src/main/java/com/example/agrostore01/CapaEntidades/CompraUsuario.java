package com.example.agrostore01.CapaEntidades;

public class CompraUsuario {
    private String idUsuario;
    private long idProductoComprado;

    public CompraUsuario() {
    }

    public CompraUsuario(String idUsuario, long idProductoComprado) {
        this.idUsuario = idUsuario;
        this.idProductoComprado = idProductoComprado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdProductoComprado() {
        return idProductoComprado;
    }

    public void setIdProductoComprado(long idProductoComprado) {
        this.idProductoComprado = idProductoComprado;
    }

    @Override
    public String toString() {
        return "CompraUsuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", idProductoComprado=" + idProductoComprado +
                '}';
    }
}
