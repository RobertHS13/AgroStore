package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Date;
import java.sql.Timestamp;

public class Comentarios implements Parcelable {

    private long idComentarios;
    private String idUsuario;
    private String comentario;
    private Timestamp fecha;
    private String respuesta;

    public Comentarios() {}

    public Comentarios(long idComentarios, String idUsuario, String comentario, Timestamp fecha, String respuesta) {
        this.idComentarios = idComentarios;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.fecha = fecha;
        this.respuesta = respuesta;
    }

    protected Comentarios(Parcel in) {
        idComentarios = in.readLong();
        idUsuario = in.readString();
        comentario = in.readString();
        respuesta = in.readString();
    }

    public static final Creator<Comentarios> CREATOR = new Creator<Comentarios>() {
        @Override
        public Comentarios createFromParcel(Parcel in) {
            return new Comentarios(in);
        }

        @Override
        public Comentarios[] newArray(int size) {
            return new Comentarios[size];
        }
    };

    public long getIdComentarios() {
        return idComentarios;
    }

    public void setIdComentarios(long idComentarios) {
        this.idComentarios = idComentarios;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idComentarios);
        dest.writeString(idUsuario);
        dest.writeString(comentario);
        dest.writeString(respuesta);
    }
}
