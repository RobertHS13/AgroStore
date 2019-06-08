package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Usuario extends Entidad implements Parcelable {

    private String idUsuario;
    private byte[] foto;
    private int idTipo;
    private long idDetalles;
    private String usuario;
    private String contrasenaUsuario;
    private String correo;

    public Usuario() {}

    public Usuario(byte[] foto, int idTipo, long idDetalles, String usuario, String contrasenaUsuario, String correo) {
        this.foto = foto;
        this.idTipo = idTipo;
        this.idDetalles = idDetalles;
        this.usuario = usuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.correo = correo;
    }

    public Usuario(String idUsuario, byte[] foto, int idTipo, long idDetalles, String usuario, String contrasenaUsuario, String correo) {
        this.idUsuario = idUsuario;
        this.foto = foto;
        this.idTipo = idTipo;
        this.idDetalles = idDetalles;
        this.usuario = usuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.correo = correo;
    }

    protected Usuario(Parcel in) {
        idUsuario = in.readString();
        foto = in.createByteArray();
        idTipo = in.readInt();
        idDetalles = in.readLong();
        usuario = in.readString();
        contrasenaUsuario = in.readString();
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

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
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

    public String getUsuario() { return usuario; }

    public void setUsuario(String usuario) { this.usuario = usuario; }

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
                ", foto=" + Arrays.toString(foto) +
                ", idTipo=" + idTipo +
                ", idDetalles=" + idDetalles +
                ", usuario='" + usuario + '\'' +
                ", contrasenaUsuario='" + contrasenaUsuario + '\'' +
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
        dest.writeByteArray(foto);
        dest.writeInt(idTipo);
        dest.writeLong(idDetalles);
        dest.writeString(usuario);
        dest.writeString(contrasenaUsuario);
        dest.writeString(correo);
    }

}
