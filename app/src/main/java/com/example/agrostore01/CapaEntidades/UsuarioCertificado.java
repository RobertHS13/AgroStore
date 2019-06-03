package com.example.agrostore01.CapaEntidades;

public class UsuarioCertificado {

    private String idUsuario;
    private int idCertificados;

    public UsuarioCertificado() {
    }

    public UsuarioCertificado(String idUsuario, int idCertificados) {
        this.idUsuario = idUsuario;
        this.idCertificados = idCertificados;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCertificados() {
        return idCertificados;
    }

    public void setIdCertificados(int idCertificados) {
        this.idCertificados = idCertificados;
    }

    @Override
    public String toString() {
        return "UsuarioCertificado{" +
                "idUsuario='" + idUsuario + '\'' +
                ", idCertificados=" + idCertificados +
                '}';
    }
}
