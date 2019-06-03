package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioTerreno;
import com.example.agrostore01.CapaEntidades.Terreno;

public class EscritorTerreno extends  Escritor<Terreno> {
    private RepositorioTerreno repositorio = new RepositorioTerreno();
    public EscritorTerreno(int operacion, Terreno terreno) {
        super(operacion, terreno);
    }

    public EscritorTerreno(int operacion, Terreno terreno, Terreno entidadCambio) {
        super(operacion, terreno, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdTerreno());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdTerreno(),entidadCambio);



        return false;

    }
}
