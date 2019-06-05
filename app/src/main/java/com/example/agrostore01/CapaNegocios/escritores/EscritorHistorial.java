package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioHistorial;
import com.example.agrostore01.CapaEntidades.Historial;

public class EscritorHistorial extends Escritor<Historial> {
    private RepositorioHistorial repositorio = new RepositorioHistorial();
    public EscritorHistorial(int operacion, Historial historial) {
        super(operacion, historial);
    }

    public EscritorHistorial(int operacion, Historial historial, Historial entidadCambio) {
        super(operacion, historial, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            repositorio.alta(entidad);

        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdHistorial());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdHistorial(),entidadCambio);

        return false;
    }

}
