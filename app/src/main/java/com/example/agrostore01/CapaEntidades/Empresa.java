package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Empresa extends Entidad implements Parcelable {

    private int idEmpresa;
    private String nombre;
    private String direccion;
    private String numTelefono;
    private String correo;

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String numTelefono, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.correo = correo;
    }

    public Empresa(int idEmpresa, String nombre, String direccion, String numTelefono, String correo) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.correo = correo;
    }

    protected Empresa(Parcel in) {
        idEmpresa = in.readInt();
        nombre = in.readString();
        direccion = in.readString();
        numTelefono = in.readString();
        correo = in.readString();
    }

    public static final Creator<Empresa> CREATOR = new Creator<Empresa>() {
        @Override
        public Empresa createFromParcel(Parcel in) {
            return new Empresa(in);
        }

        @Override
        public Empresa[] newArray(int size) {
            return new Empresa[size];
        }
    };

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idEmpresa);
        dest.writeString(nombre);
        dest.writeString(direccion);
        dest.writeString(numTelefono);
        dest.writeString(correo);
    }
}
