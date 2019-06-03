package com.example.agrostore01.CapaEntidades;

public class Carrito {
    private long idCar;
    private String idUsuario;

    public Carrito() {
    }

    public Carrito(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Carrito(long idCar, String idUsuario) {
        this.idCar = idCar;
        this.idUsuario = idUsuario;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "idCar=" + idCar +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }

}
