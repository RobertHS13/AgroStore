package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Usuario extends Entidad implements Parcelable {

    private String idUsuario;
    private String contraseñaUsuario;
    private int idTipo;
    private long idDetalles;
    private byte[] foto;
    private String correo;

    public Usuario() {}

    public Usuario(String contraseñaUsuario, int idTipo, long idDetalles, byte[] foto, String correo) {
        this.contraseñaUsuario = contraseñaUsuario;
        this.idTipo = idTipo;
        this.idDetalles = idDetalles;
        this.foto = foto;
        this.correo = correo;
    }

    public Usuario(String idUsuario, String contraseñaUsuario, int idTipo, long idDetalles, byte[] foto, String correo) {
        this.idUsuario = idUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.idTipo = idTipo;
        this.idDetalles = idDetalles;
        this.foto = foto;
        this.correo = correo;
    }

    protected Usuario(Parcel in) {
        idUsuario = in.readString();
        contraseñaUsuario = in.readString();
        idTipo = in.readInt();
        idDetalles = in.readLong();
        foto = in.createByteArray();
        correo = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public long getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(long idDetalles) {
        this.idDetalles = idDetalles;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", contraseñaUsuario='" + contraseñaUsuario + '\'' +
                ", idTipo=" + idTipo +
                ", idDetalles=" + idDetalles +
                ", foto=" + Arrays.toString(foto) +
                ", correo='" + correo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idUsuario);
        dest.writeString(contraseñaUsuario);
        dest.writeInt(idTipo);
        dest.writeLong(idDetalles);
        dest.writeByteArray(foto);
        dest.writeString(correo);
    }

}
