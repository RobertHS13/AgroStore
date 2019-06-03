package com.example.agrostore01.CapaEntidades;

public class DetallesUsuario {

    private long idDetalles;
    private String calle;
    private String colonia;
    private String cuidad;
    private String estado;
    private String pais;
    private int cp;
    private String escrituraOPermiso;
    private double estrellas;
    private String rfc;
    private String firmaElectronica;
    private String nombres;
    private String apellidos;

    public DetallesUsuario() {
    }

    public DetallesUsuario(String calle, String colonia, String cuidad, String estado, String pais, int cp, String escrituraOPermiso, double estrellas, String rfc, String firmaElectronica, String nombres, String apellidos) {
        this.calle = calle;
        this.colonia = colonia;
        this.cuidad = cuidad;
        this.estado = estado;
        this.pais = pais;
        this.cp = cp;
        this.escrituraOPermiso = escrituraOPermiso;
        this.estrellas = estrellas;
        this.rfc = rfc;
        this.firmaElectronica = firmaElectronica;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public DetallesUsuario(long idDetalles, String calle, String colonia, String cuidad, String estado, String pais, int cp, String escrituraOPermiso, double estrellas, String rfc, String firmaElectronica, String nombres, String apellidos) {
        this.idDetalles = idDetalles;
        this.calle = calle;
        this.colonia = colonia;
        this.cuidad = cuidad;
        this.estado = estado;
        this.pais = pais;
        this.cp = cp;
        this.escrituraOPermiso = escrituraOPermiso;
        this.estrellas = estrellas;
        this.rfc = rfc;
        this.firmaElectronica = firmaElectronica;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public long getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(long idDetalles) {
        this.idDetalles = idDetalles;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getEscrituraOPermiso() {
        return escrituraOPermiso;
    }

    public void setEscrituraOPermiso(String escrituraOPermiso) {
        this.escrituraOPermiso = escrituraOPermiso;
    }

    public double getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(double estrellas) {
        this.estrellas = estrellas;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getFirmaElectronica() {
        return firmaElectronica;
    }

    public void setFirmaElectronica(String firmaElectronica) {
        this.firmaElectronica = firmaElectronica;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "DetallesUsuario{" +
                "idDetalles=" + idDetalles +
                ", calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cuidad='" + cuidad + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", cp=" + cp +
                ", escrituraOPermiso='" + escrituraOPermiso + '\'' +
                ", estrellas=" + estrellas +
                ", rfc='" + rfc + '\'' +
                ", firmaElectronica='" + firmaElectronica + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
