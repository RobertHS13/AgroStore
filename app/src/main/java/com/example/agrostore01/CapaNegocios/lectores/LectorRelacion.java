package com.example.agrostore01.CapaNegocios.lectores;

import java.util.ArrayList;

public abstract class  LectorRelacion<Entidad> extends Lector<Entidad> {

        public abstract ArrayList<Entidad> getEntidadesId(Object id);

}
