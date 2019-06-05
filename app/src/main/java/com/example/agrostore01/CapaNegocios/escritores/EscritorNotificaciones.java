package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioNotificaciones;
import com.example.agrostore01.CapaEntidades.Notificaciones;

public class EscritorNotificaciones extends Escritor<Notificaciones> {
    private RepositorioNotificaciones repositorio = new RepositorioNotificaciones();
    public EscritorNotificaciones(int operacion, Notificaciones notificaciones) {
        super(operacion, notificaciones);
    }

    public EscritorNotificaciones(int operacion, Notificaciones notificaciones, Notificaciones entidadCambio) {
        super(operacion, notificaciones, entidadCambio);
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
