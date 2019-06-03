package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioUsuarioCertificado;
import com.example.agrostore01.CapaEntidades.UsuarioCertificado;

public class EscritorUsuarioCertificado extends EscritorRelacion<UsuarioCertificado> {
    private RepositorioUsuarioCertificado repositorio = new RepositorioUsuarioCertificado();

    public EscritorUsuarioCertificado(int operacion, UsuarioCertificado usuarioCertificado) {
        super(operacion, usuarioCertificado);
    }

    public EscritorUsuarioCertificado(int operacion, UsuarioCertificado usuarioCertificado, UsuarioCertificado entidadCambio) {
        super(operacion, usuarioCertificado, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            return repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdCertificados());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdCertificados(),entidadCambio);



        return false;
    }

}
