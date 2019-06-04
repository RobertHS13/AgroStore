package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Terreno extends Entidad implements Parcelable {

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

    protected Terreno(Parcel in) {
        idTerreno = in.readLong();
        tamaño = in.readInt();
        medida = in.readString();
        tipo = in.readString();
    }

    public static final Creator<Terreno> CREATOR = new Creator<Terreno>() {
        @Override
        public Terreno createFromParcel(Parcel in) {
            return new Terreno(in);
        }

        @Override
        public Terreno[] newArray(int size) {
            return new Terreno[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idTerreno);
        dest.writeInt(tamaño);
        dest.writeString(medida);
        dest.writeString(tipo);
    }
}
