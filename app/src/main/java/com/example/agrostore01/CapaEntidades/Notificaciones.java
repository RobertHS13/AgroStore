package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Notificaciones extends Entidad implements Parcelable {

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

    protected Notificaciones(Parcel in) {
        idNotificacion = in.readLong();
        detalle = in.readString();
    }

    public static final Creator<Notificaciones> CREATOR = new Creator<Notificaciones>() {
        @Override
        public Notificaciones createFromParcel(Parcel in) {
            return new Notificaciones(in);
        }

        @Override
        public Notificaciones[] newArray(int size) {
            return new Notificaciones[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idNotificacion);
        dest.writeString(detalle);
    }
}
