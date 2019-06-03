package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioUsuarioNotificaciones;
import com.example.agrostore01.CapaEntidades.UsuarioNotificaciones;

public class EscritorUsuarioNotificaciones extends  EscritorRelacion<UsuarioNotificaciones> {
    private RepositorioUsuarioNotificaciones repositorio = new RepositorioUsuarioNotificaciones();

    public EscritorUsuarioNotificaciones(int operacion, UsuarioNotificaciones usuarioNotificaciones) {
        super(operacion, usuarioNotificaciones);
    }

    public EscritorUsuarioNotificaciones(int operacion, UsuarioNotificaciones usuarioNotificaciones, UsuarioNotificaciones entidadCambio) {
        super(operacion, usuarioNotificaciones, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdNotificacion());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdNotificacion(),entidadCambio);



        return false;

    }


}
