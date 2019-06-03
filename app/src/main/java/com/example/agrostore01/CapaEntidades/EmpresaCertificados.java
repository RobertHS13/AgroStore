package com.example.agrostore01.CapaEntidades;

public class EmpresaCertificados {

    private int idCertificados;
    private int idEmpresa;

    public EmpresaCertificados() {
    }

    public EmpresaCertificados(int idCertificados, int idEmpresa) {
        this.idCertificados = idCertificados;
        this.idEmpresa = idEmpresa;
    }

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
}
