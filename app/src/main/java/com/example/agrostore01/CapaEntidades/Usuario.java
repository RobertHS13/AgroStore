package com.example.agrostore01.CapaEntidades;

import java.util.Arrays;

public class Usuario {
    private String idUsuario;
    private String contraseñaUsuario;
    private int idTipo;
    private long idDetalles;
    private byte[] foto;
    private String correo;

    public Usuario() {
    }

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
}