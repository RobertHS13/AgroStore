package com.example.agrostore01.CapaNegocios.lectores;

import java.util.ArrayList;

public abstract class Lector<Entidad>{

    public abstract  Entidad getEntidadId(Object id);
    public abstract ArrayList<Entidad> getEntidades();

}
