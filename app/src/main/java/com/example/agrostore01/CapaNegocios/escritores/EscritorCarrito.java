package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioCarrito;
import com.example.agrostore01.CapaEntidades.Carrito;

public class EscritorCarrito extends Escritor<Carrito> {
    private RepositorioCarrito repositorio = new RepositorioCarrito();
    public EscritorCarrito(int operacion, Carrito carrito) {
        super(operacion, carrito);
    }

    public EscritorCarrito(int operacion, Carrito carrito, Carrito entidadCambio) {
        super(operacion, carrito, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            return repositorio.alta(entidad);

        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdCar());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdCar(),entidadCambio);



        return false;
    }
}
