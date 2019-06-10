package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Timestamp;
import java.util.Arrays;

public class Certificados extends Entidad implements Parcelable {

    private int idCertificados;
    private String nombre;
    private java.sql.Timestamp vigencia;
    private String tituloCertificado;
    private java.sql.Timestamp fechaExpedido;
    private byte[] sello;

    public Certificados() {}

    public Certificados(int idCertificados, String nombre, Timestamp vigencia, String tituloCertificado, Timestamp fechaExpedido, byte[] sello) {
        this.idCertificados = idCertificados;
        this.nombre = nombre;
        this.vigencia = vigencia;
        this.tituloCertificado = tituloCertificado;
        this.fechaExpedido = fechaExpedido;
        this.sello = sello;
    }

    protected Certificados(Parcel in) {
        idCertificados = in.readInt();
        nombre = in.readString();
        tituloCertificado = in.readString();
        sello = in.createByteArray();
    }

    public static final Creator<Certificados> CREATOR = new Creator<Certificados>() {
        @Override
        public Certificados createFromParcel(Parcel in) {
            return new Certificados(in);
        }

        @Override
        public Certificados[] newArray(int size) {
            return new Certificados[size];
        }
    };

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idCertificados);
        dest.writeString(nombre);
        dest.writeString(tituloCertificado);
        dest.writeByteArray(sello);
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
