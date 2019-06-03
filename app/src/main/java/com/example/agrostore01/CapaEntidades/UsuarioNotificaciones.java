package com.example.agrostore01.CapaEntidades;

public class UsuarioNotificaciones {
    private String idUsuario;
    private long idNotificacion;

    public UsuarioNotificaciones() {
    }

    public UsuarioNotificaciones(String idUsuario, long idNotificacion) {
        this.idUsuario = idUsuario;
        this.idNotificacion = idNotificacion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    @Override
    public String toString() {
        return "UsuarioNotificaciones{" +
                "idUsuario='" + idUsuario + '\'' +
                ", idNotificacion=" + idNotificacion +
                '}';
    }
}
