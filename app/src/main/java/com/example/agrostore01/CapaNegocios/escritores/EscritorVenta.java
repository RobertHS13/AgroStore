package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioVenta;
import com.example.agrostore01.CapaEntidades.Venta;

public class EscritorVenta extends Escritor<Venta> {

    private RepositorioVenta repositorio = new RepositorioVenta();
    public EscritorVenta(int operacion, Venta venta) {
        super(operacion, venta);
    }

    public EscritorVenta(int operacion, Venta venta, Venta entidadCambio) {
        super(operacion, venta, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdVenta());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdVenta(),entidadCambio);



        return false;
    }
}
