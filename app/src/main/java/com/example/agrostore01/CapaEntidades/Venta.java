package com.example.agrostore01.CapaEntidades;

public class Venta {

    private long idVenta;
    private String idUsuarioAgricultor;
    private String idUsuarioCliente;
    private long idDetalle;

    public Venta() {
    }

    public Venta(String idUsuarioAgricultor, String idUsuarioCliente, long idDetalle) {
        this.idUsuarioAgricultor = idUsuarioAgricultor;
        this.idUsuarioCliente = idUsuarioCliente;
        this.idDetalle = idDetalle;
    }

    public Venta(long idVenta, String idUsuarioAgricultor, String idUsuarioCliente, long idDetalle) {
        this.idVenta = idVenta;
        this.idUsuarioAgricultor = idUsuarioAgricultor;
        this.idUsuarioCliente = idUsuarioCliente;
        this.idDetalle = idDetalle;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdUsuarioAgricultor() {
        return idUsuarioAgricultor;
    }

    public void setIdUsuarioAgricultor(String idUsuarioAgricultor) {
        this.idUsuarioAgricultor = idUsuarioAgricultor;
    }

    public String getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(String idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(long idDetalle) {
        this.idDetalle = idDetalle;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", idUsuarioAgricultor='" + idUsuarioAgricultor + '\'' +
                ", idUsuarioCliente='" + idUsuarioCliente + '\'' +
                ", idDetalle=" + idDetalle +
                '}';
    }
}
