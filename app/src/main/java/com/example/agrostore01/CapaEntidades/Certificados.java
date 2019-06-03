package com.example.agrostore01.CapaEntidades;

import java.sql.Timestamp;
import java.util.Arrays;

public class Certificados {
    
    private int idCertificados;
    private String nombre;
    private java.sql.Timestamp vigencia;
    private String tituloCertificado;
    private java.sql.Timestamp fechaExpedido;
    private byte[] sello;

    public Certificados() {
    }

    public Certificados(String nombre, Timestamp vigencia, String tituloCertificado, Timestamp fechaExpedido, byte[] sello) {
        this.nombre = nombre;
        this.vigencia = vigencia;
        this.tituloCertificado = tituloCertificado;
        this.fechaExpedido = fechaExpedido;
        this.sello = sello;
    }

    public Certificados(int idCertificados, String nombre, Timestamp vigencia, String tituloCertificado, Timestamp fechaExpedido, byte[] sello) {
        this.idCertificados = idCertificados;
        this.nombre = nombre;
        this.vigencia = vigencia;
        this.tituloCertificado = tituloCertificado;
        this.fechaExpedido = fechaExpedido;
        this.sello = sello;
    }

    public int getIdCertificados() {
        return idCertificados;
    }

    public void setIdCertificados(int idCertificados) {
        this.idCertificados = idCertificados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Timestamp getVigencia() {
        return vigencia;
    }

    public void setVigencia(Timestamp vigencia) {
        this.vigencia = vigencia;
    }

    public String getTituloCertificado() {
        return tituloCertificado;
    }

    public void setTituloCertificado(String tituloCertificado) {
        this.tituloCertificado = tituloCertificado;
    }

    public Timestamp getFechaExpedido() {
        return fechaExpedido;
    }

    public void setFechaExpedido(Timestamp fechaExpedido) {
        this.fechaExpedido = fechaExpedido;
    }

    public byte[] getSello() {
        return sello;
    }

    public void setSello(byte[] sello) {
        this.sello = sello;
    }

    @Override
    public String toString() {
        return "Certificados{" +
                "idCertificados=" + idCertificados +
                ", nombre='" + nombre + '\'' +
                ", vigencia=" + vigencia +
                ", tituloCertificado='" + tituloCertificado + '\'' +
                ", fechaExpedido=" + fechaExpedido +
                ", sello=" + Arrays.toString(sello) +
                '}';
    }
}
