package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;

public class EscritorUsuario extends Escritor<Usuario> {
    private RepositorioUsuario repositorio = new RepositorioUsuario();
    public EscritorUsuario(int operacion, Usuario usuario) {
        super(operacion, usuario);
    }

    public EscritorUsuario(int operacion, Usuario usuario, Usuario entidadCambio) {
        super(operacion, usuario, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            return repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdUsuario());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdUsuario(),entidadCambio);


        return false;
    }
}
