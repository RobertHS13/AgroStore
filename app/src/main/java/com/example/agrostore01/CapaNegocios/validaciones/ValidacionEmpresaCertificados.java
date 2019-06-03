package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.EmpresaCertificados;

public class ValidacionEmpresaCertificados extends  Validacion<EmpresaCertificados> {
    public ValidacionEmpresaCertificados(EmpresaCertificados empresaCertificados) {
        super(empresaCertificados);
    }

    /*
        *   private int idCertificados;
        private int idEmpresa;

        * */
    public boolean validarIdCertificados(){
        if (entidad.getIdCertificados()==0)
            return false;
        return true;
    }
    public boolean validarIdEmpresa(){
        if (entidad.getIdEmpresa()==0)
            return false;

        return true;
    }

    @Override
    public boolean validar() {
        return validarIdCertificados() && validarIdEmpresa();

    }
}
