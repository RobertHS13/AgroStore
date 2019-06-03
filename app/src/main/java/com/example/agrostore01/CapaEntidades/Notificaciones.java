package com.example.agrostore01.CapaEntidades;

public class Notificaciones {
    private long idNotificacion;
    private String detalle;

    public Notificaciones() {
    }

    public Notificaciones(String detalle) {
        this.detalle = detalle;
    }

    public Notificaciones(long idNotificacion, String detalle) {
        this.idNotificacion = idNotificacion;
        this.detalle = detalle;
    }

    public long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Notificaciones{" +
                "idNotificacion=" + idNotificacion +
                ", detalle='" + detalle + '\'' +
                '}';
    }
}
