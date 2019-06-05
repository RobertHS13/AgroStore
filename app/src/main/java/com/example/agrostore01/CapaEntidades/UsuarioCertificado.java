package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class UsuarioCertificado extends Entidad implements Parcelable {

    private String idUsuario;
    private int idCertificados;

    public UsuarioCertificado() {
    }

    public UsuarioCertificado(String idUsuario, int idCertificados) {
        this.idUsuario = idUsuario;
        this.idCertificados = idCertificados;
    }

    protected UsuarioCertificado(Parcel in) {
        idUsuario = in.readString();
        idCertificados = in.readInt();
    }

    public static final Creator<UsuarioCertificado> CREATOR = new Creator<UsuarioCertificado>() {
        @Override
        public UsuarioCertificado createFromParcel(Parcel in) {
            return new UsuarioCertificado(in);
        }

        @Override
        public UsuarioCertificado[] newArray(int size) {
            return new UsuarioCertificado[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idUsuario);
        dest.writeInt(idCertificados);
    }
}
