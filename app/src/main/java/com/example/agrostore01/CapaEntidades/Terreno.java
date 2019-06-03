package com.example.agrostore01.CapaEntidades;

public class Terreno {
    private long idTerreno;
    private int tamaño;
    private String medida;
    private String tipo;

    public Terreno() {
    }

    public Terreno(int tamaño, String medida, String tipo) {
        this.tamaño = tamaño;
        this.medida = medida;
        this.tipo = tipo;
    }

    public Terreno(long idTerreno, int tamaño, String medida, String tipo) {
        this.idTerreno = idTerreno;
        this.tamaño = tamaño;
        this.medida = medida;
        this.tipo = tipo;
    }

    public long getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(long idTerreno) {
        this.idTerreno = idTerreno;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Terreno{" +
                "idTerreno=" + idTerreno +
                ", tamaño=" + tamaño +
                ", medida='" + medida + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
