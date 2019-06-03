package com.example.agrostore01.CapaEntidades;

public class Historial {
    private long idHistorial;
    private String busqueda;
    private String idUsuario;

    public Historial() {
    }

    public Historial(String busqueda, String idUsuario) {
        this.busqueda = busqueda;
        this.idUsuario = idUsuario;
    }

    public Historial(long idHistorial, String busqueda, String idUsuario) {
        this.idHistorial = idHistorial;
        this.busqueda = busqueda;
        this.idUsuario = idUsuario;
    }

    public long getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "idHistorial=" + idHistorial +
                ", busqueda='" + busqueda + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }
}
