package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.UsuarioCertificado;

public class ValidacionUsuarioCertificado extends  Validacion<UsuarioCertificado> {

    public ValidacionUsuarioCertificado(UsuarioCertificado usuarioCertificado) {
        super(usuarioCertificado);
    }

    /*
        *     private String idUsuario;
        private int idCertificados;
        * */
    public boolean validarIdUsuario(){
        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true;
    }
    public boolean validarCertificado(){
        if (entidad.getIdCertificados()==0)
            return false;
        return true;
    }

    @Override
    public boolean validar() {
        return  validarIdUsuario() && validarCertificado();
    }
}
