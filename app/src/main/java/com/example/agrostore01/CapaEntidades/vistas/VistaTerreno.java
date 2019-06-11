package com.example.agrostore01.CapaEntidades.vistas;

import android.os.Parcel;
import android.os.Parcelable;

public class VistaTerreno implements Parcelable {

    private int idTerreno;
    private String medida;
    private float tamano;
    private String tipo;

    public VistaTerreno(int idTerreno, String medida, float tamano, String tipo) {
        this.idTerreno = idTerreno;
        this.medida = medida;
        this.tamano = tamano;
        this.tipo = tipo;
    }

    protected VistaTerreno(Parcel in) {
        idTerreno = in.readInt();
        medida = in.readString();
        tamano = in.readFloat();
        tipo = in.readString();
    }

    public static final Creator<VistaTerreno> CREATOR = new Creator<VistaTerreno>() {
        @Override
        public VistaTerreno createFromParcel(Parcel in) {
            return new VistaTerreno(in);
        }

        @Override
        public VistaTerreno[] newArray(int size) {
            return new VistaTerreno[size];
        }
    };

    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public float getTamano() {
        return tamano;
    }

    public void setTamano(float tamano) {
        this.tamano = tamano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "VistaTerreno{" +
                "idTerreno=" + idTerreno +
                ", medida='" + medida + '\'' +
                ", tamano=" + tamano +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idTerreno);
        dest.writeString(medida);
        dest.writeFloat(tamano);
        dest.writeString(tipo);
    }
}
