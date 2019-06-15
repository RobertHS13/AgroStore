package com.example.agrostore01.CapaEntidades.vistas;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Date;

public class VistaComentarios implements Parcelable {

    private String nombreUsuario;
    private String apellidoUsuario;
    private String comentario;
    private String respuesta;
    private Date fecha;

    public VistaComentarios() {}

    public VistaComentarios(String nombreUsuario, String apellidoUsuario, String comentario, String respuesta, Date fecha) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.comentario = comentario;
        this.respuesta = respuesta;
        this.fecha = fecha;
    }

    protected VistaComentarios(Parcel in) {
        nombreUsuario = in.readString();
        apellidoUsuario = in.readString();
        comentario = in.readString();
        respuesta = in.readString();
    }

    public static final Creator<VistaComentarios> CREATOR = new Creator<VistaComentarios>() {
        @Override
        public VistaComentarios createFromParcel(Parcel in) {
            return new VistaComentarios(in);
        }

        @Override
        public VistaComentarios[] newArray(int size) {
            return new VistaComentarios[size];
        }
    };

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "VistaComentarios{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", apellidoUsuario='" + apellidoUsuario + '\'' +
                ", comentario='" + comentario + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombreUsuario);
        dest.writeString(apellidoUsuario);
        dest.writeString(comentario);
        dest.writeString(respuesta);
    }
}
