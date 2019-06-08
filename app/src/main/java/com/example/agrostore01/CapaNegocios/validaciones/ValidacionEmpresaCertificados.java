package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.EmpresaCertificados;

public class ValidacionEmpresaCertificados extends  Validacion<EmpresaCertificados> {
    public ValidacionEmpresaCertificados(EmpresaCertificados empresaCertificados) {
        super(empresaCertificados);
    }

    public boolean validarIdCertificados(){
        System.out.println("Validating EmpresaCertificados.IdCertificados " + entidad.getIdCertificados());
        if (entidad.getIdCertificados()<=-1)
            return false;
        return true;
    }

    public boolean validarIdEmpresa(){
        System.out.println("Validating EmpresaCertificados. "+entidad.getIdEmpresa());
        if (entidad.getIdEmpresa()<=-1)
            return false;

        return true;
    }

    @Override
    public boolean validar() {
        return validarIdCertificados() && validarIdEmpresa();

    }
}
