package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Historial extends Entidad implements Parcelable {

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

    protected Historial(Parcel in) {
        idHistorial = in.readLong();
        busqueda = in.readString();
        idUsuario = in.readString();
    }

    public static final Creator<Historial> CREATOR = new Creator<Historial>() {
        @Override
        public Historial createFromParcel(Parcel in) {
            return new Historial(in);
        }

        @Override
        public Historial[] newArray(int size) {
            return new Historial[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idHistorial);
        dest.writeString(busqueda);
        dest.writeString(idUsuario);
    }
}
