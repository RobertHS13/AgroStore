package com.example.agrostore01.CapaEntidades;

public class Empresa {

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
}
