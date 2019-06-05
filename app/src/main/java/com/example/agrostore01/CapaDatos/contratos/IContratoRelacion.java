package com.example.agrostore01.CapaDatos.contratos;

import java.util.ArrayList;

public interface IContratoRelacion<Entidad> extends IContrato<Entidad> {
    boolean bajaEspecifica(Entidad e);
    ArrayList<Entidad> seleccionarTodosId(Object id);
}
