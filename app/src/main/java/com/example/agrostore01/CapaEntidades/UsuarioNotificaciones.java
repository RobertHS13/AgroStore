package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class UsuarioNotificaciones extends Entidad implements Parcelable {

    private String idUsuario;
    private long idNotificacion;

    public UsuarioNotificaciones() {
    }

    public UsuarioNotificaciones(String idUsuario, long idNotificacion) {
        this.idUsuario = idUsuario;
        this.idNotificacion = idNotificacion;
    }

    protected UsuarioNotificaciones(Parcel in) {
        idUsuario = in.readString();
        idNotificacion = in.readLong();
    }

    public static final Creator<UsuarioNotificaciones> CREATOR = new Creator<UsuarioNotificaciones>() {
        @Override
        public UsuarioNotificaciones createFromParcel(Parcel in) {
            return new UsuarioNotificaciones(in);
        }

        @Override
        public UsuarioNotificaciones[] newArray(int size) {
            return new UsuarioNotificaciones[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idUsuario);
        dest.writeLong(idNotificacion);
    }
}
