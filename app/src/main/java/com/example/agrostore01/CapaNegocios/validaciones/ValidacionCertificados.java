package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Certificados;

import java.util.Arrays;

public class ValidacionCertificados extends Validacion<Certificados> {

    public ValidacionCertificados(Certificados certificados) {
        super(certificados);
    }

    public boolean validarIdCertificados(){
        System.out.println("Validating Certificados.IdCertificados "+ entidad.getIdCertificados());

        if (entidad.getIdCertificados() <= -1)
            return false;

        return true;
    }
    public boolean validarNombre(){
        System.out.println("Validating Certificados.Nombre "+ entidad.getNombre());
        if(entidad.getNombre() == null)
            return false;

        if (entidad.getNombre().isEmpty())
            return false;
        return true;
    }
    public boolean validarVigencia(){
        System.out.println("Validating Certificados.Vigencia "+ entidad.getVigencia());
        return true;
    }
    public boolean validarTituloCertificado(){
        System.out.println("Validating Certificados.TituloCertificado "+ entidad.getTituloCertificado());

        if (entidad.getTituloCertificado() == null)
            return false;

        if (entidad.getTituloCertificado().isEmpty())
            return false;

        return true;

    }
    public boolean validarFechaExpedido(){
        System.out.println("Validating Certificados.FechaExpedido "+ entidad.getFechaExpedido());

        return true;
    }
    public boolean validarSello(){
        System.out.println("Validating Certificados.Sello "+ Arrays.toString(entidad.getSello()));
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdCertificados() && validarNombre() && validarVigencia() && validarTituloCertificado() && validarFechaExpedido() && validarSello();
    }

}
