package com.example.agrostore01.CapaEntidades;

public class MultiplesCompras {
    private long idNumProducto;
    private long idCar;

    public MultiplesCompras() {
    }

    public MultiplesCompras(long idNumProducto, long idCar) {
        this.idNumProducto = idNumProducto;
        this.idCar = idCar;
    }

    public long getIdNumProducto() {
        return idNumProducto;
    }

    public void setIdNumProducto(long idNumProducto) {
        this.idNumProducto = idNumProducto;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    @Override
    public String toString() {
        return "MultiplesCompras{" +
                "idNumProducto=" + idNumProducto +
                ", idCar=" + idCar +
                '}';
    }
}
