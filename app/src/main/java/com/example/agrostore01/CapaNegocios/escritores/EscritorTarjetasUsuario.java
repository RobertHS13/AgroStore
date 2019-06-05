package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioTarjetasUsuario;
import com.example.agrostore01.CapaEntidades.TarjetasUsuario;

public class EscritorTarjetasUsuario extends EscritorRelacion<TarjetasUsuario> {

    private RepositorioTarjetasUsuario repositorio = new RepositorioTarjetasUsuario();

    public EscritorTarjetasUsuario(int operacion, TarjetasUsuario tarjetasUsuario) {
        super(operacion, tarjetasUsuario);
    }

    public EscritorTarjetasUsuario(int operacion, TarjetasUsuario tarjetasUsuario, TarjetasUsuario entidadCambio) {
        super(operacion, tarjetasUsuario, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdUsuario());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdUsuario(),entidadCambio);



        return false;

    }

}
