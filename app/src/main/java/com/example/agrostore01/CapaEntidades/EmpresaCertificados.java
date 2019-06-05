package com.example.agrostore01.CapaEntidades;

import android.os.Parcel;
import android.os.Parcelable;

public class EmpresaCertificados extends Entidad implements Parcelable {

    private int idCertificados;
    private int idEmpresa;

    public EmpresaCertificados() {
    }

    public EmpresaCertificados(int idCertificados, int idEmpresa) {
        this.idCertificados = idCertificados;
        this.idEmpresa = idEmpresa;
    }

    protected EmpresaCertificados(Parcel in) {
        idCertificados = in.readInt();
        idEmpresa = in.readInt();
    }

    public static final Creator<EmpresaCertificados> CREATOR = new Creator<EmpresaCertificados>() {
        @Override
        public EmpresaCertificados createFromParcel(Parcel in) {
            return new EmpresaCertificados(in);
        }

        @Override
        public EmpresaCertificados[] newArray(int size) {
            return new EmpresaCertificados[size];
        }
    };

    public int getIdCertificados() {
        return idCertificados;
    }

    public void setIdCertificados(int idCertificados) {
        this.idCertificados = idCertificados;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "EmpresaCertificados{" +
                "idCertificados=" + idCertificados +
                ", idEmpresa=" + idEmpresa +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idCertificados);
        dest.writeInt(idEmpresa);
    }
}
