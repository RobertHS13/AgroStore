package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioTipoUsuario;
import com.example.agrostore01.CapaEntidades.TipoUsuario;

public class EscritorTipoUsuario extends Escritor<TipoUsuario> {
    private RepositorioTipoUsuario repositorio = new RepositorioTipoUsuario();

    public EscritorTipoUsuario(int operacion, TipoUsuario tipoUsuario) {
        super(operacion, tipoUsuario);
    }

    public EscritorTipoUsuario(int operacion, TipoUsuario tipoUsuario, TipoUsuario entidadCambio) {
        super(operacion, tipoUsuario, entidadCambio);
    }


    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            return repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdTipo());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdTipo(),entidadCambio);


        return false;
    }
}
